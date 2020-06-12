package com.onlineApp.Service;

import com.onlineApp.ExceptionHandler.ResourceAlreadyExistException;
import com.onlineApp.ExceptionHandler.ResourceNotFoundException;
import com.onlineApp.Model.Cart;
import com.onlineApp.Model.Customer;
import com.onlineApp.Model.Product;
import com.onlineApp.Repository.CartRepository;
import com.onlineApp.Repository.CustomerRepository;
import com.onlineApp.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public List<Cart> getCart(long customer_id) {
        if (customerRepository.findById(customer_id).isPresent()) {
            return cartRepository.findAllCartByCustomerId(customer_id);
        } else {
            throw new ResourceNotFoundException("Customer not found with id " + customer_id);
        }
    }

    public Cart addCart(long customer_id, long product_id, Cart req_cart) {
        Optional<Customer> customer = customerRepository.findById(customer_id);
        Optional<Product> product = productRepository.findById(product_id);
        Optional<Cart> cart = Optional.ofNullable(cartRepository.findCartByCustomerIdAndProductId(customer_id, product_id));

        if (customer.isPresent()) {
            if (product.isPresent()) {
                if (!cart.isPresent()) {
                    req_cart.setCustomer(customer.get());
                    Product getProduct = product.get();
                    req_cart.setProduct(getProduct);
                } else {
                    throw new ResourceAlreadyExistException("Product already added to the cart");
                }
            } else {
                throw new ResourceNotFoundException("Product with id " + product_id + " has not found!");
            }
        } else {
            throw new ResourceNotFoundException("Customer with id " + customer_id + " has not found!");
        }
        cartRepository.save(req_cart);
        return req_cart;
    }
}
