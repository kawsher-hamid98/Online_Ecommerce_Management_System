package com.onlineApp.Controller;

import com.onlineApp.ExceptionHandler.ResourceNotFoundException;
import com.onlineApp.Model.Cart;
import com.onlineApp.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/customers/{customer_id}/cart")
    public ResponseEntity<List<Cart>> getCart(@PathVariable long customer_id) {
        List<Cart> cartList = cartService.getCart(customer_id);
        if (cartList.size() > 0) {
            return new ResponseEntity<>(cartList, HttpStatus.FOUND);
        }
        throw new ResourceNotFoundException("No cart is found for customer with id " + customer_id);
    }

    @PostMapping("/customers/{customer_id}/products/{product_id}/cart")
    public Cart addCart(@PathVariable long customer_id, @PathVariable long product_id, @Valid @RequestBody Cart req_cart) {
        return cartService.addCart(customer_id, product_id, req_cart);
    }
}
