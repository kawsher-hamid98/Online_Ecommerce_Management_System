package com.onlineApp.Controller;

import com.onlineApp.ExceptionHandler.ResourceNotFoundException;
import com.onlineApp.Model.OrderDetails;
import com.onlineApp.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String getHome() {
        return ("<h1>home</h1>");
    }

    @GetMapping("/user")
    public String userAdmin() {
        return ("<h1>user</h1>");
    }

    @GetMapping("/admin")
    public String register() {
        return ("<h1>admin</h1>");
    }





//    @GetMapping(value = "/customers/{customer_id}/orders")
//    public ResponseEntity<List<OrderDetails>> getAllOrder(@PathVariable long customer_id) {
//        List<OrderDetails> orderDetailsList = orderService.getAllOrder(customer_id);
//        if (orderDetailsList != null) {
//            return new ResponseEntity<>(orderDetailsList, HttpStatus.FOUND);
//        } else {
//            throw new ResourceNotFoundException("Order has not placed yet!");
//        }
//    }
//
//    @PostMapping(value = "/customers/{customer_id}/order")
//    public ResponseEntity<OrderDetails> placeOrder(@PathVariable long customer_id) throws Exception {
//        OrderDetails orderDetails = orderService.placeOrder(customer_id);
//        return new ResponseEntity<>(orderDetails, HttpStatus.CREATED);
//    }
}
