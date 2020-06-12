package com.onlineApp.Service;

import com.onlineApp.ExceptionHandler.ResourceNotFoundException;
import com.onlineApp.Model.*;
import com.onlineApp.Repository.CartRepository;
import com.onlineApp.Repository.CustomerRepository;
import com.onlineApp.Repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    public OrderDetails placeOrder(long customer_id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(customer_id);
        OrderDetails orderDetails = new OrderDetails();
        List<QuantityProduct> quantityProductList = new ArrayList<>();

        if (customer.isPresent()) {
            logger.info("Customer found with id " + customer_id);
            List<Cart> cartList = cartRepository.findAllCartByCustomerId(customer_id);
            if (cartList.size() > 0) {
                double totalPrice = 0;
                for (Cart cart: cartList) {
                    QuantityProduct quantityProduct = new QuantityProduct();
                    quantityProduct.setProducts(cart.getProduct());
                    quantityProduct.setQuantity(cart.getQty());
                    quantityProduct.setPriceWithQuantityTotal(cart.getQty() * (cart.getProduct().getProductPrice()));
                    totalPrice += quantityProduct.getPriceWithQuantityTotal();
                    quantityProductList.add(quantityProduct);
                }
                orderDetails.setCustomer(customer.get());
                orderDetails.setProductWithQuantity(quantityProductList);
                orderDetails.setTotalPrice(totalPrice);
                logger.info("Saving order details...");
                try {
                    try {
                        orderRepository.save(orderDetails);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        throw new Exception("Can not save order");
                    }
                    cartRepository.deleteAllCartByCustomerId(customer_id);
                } catch (Exception exception) {
                    exception.printStackTrace();
                    throw new Exception("Can not delete cart");
                }
            } else {
                throw new ResourceNotFoundException("Cart is empty for customer with id " + customer_id);
            }
        } else {
            throw new ResourceNotFoundException("Customer with id " + customer_id + " has not found!");
        }
        return orderDetails;
    }

    public List<OrderDetails> getAllOrder(long customer_id) {
        Optional<Customer> customer = customerRepository.findById(customer_id);

        if (customer.isPresent()) {
            List<OrderDetails> orderDetailsList = orderRepository.findAllOrdersByCustomerId(customer_id);
            if (orderDetailsList.size() > 0) {
                logger.info("Sending order details....");
                return orderDetailsList;
            } else {
                return null;
            }
        } else {
            throw new ResourceNotFoundException("Customer with id " + customer_id + " has not found!");
        }
    }
}
