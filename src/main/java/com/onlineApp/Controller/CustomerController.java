package com.onlineApp.Controller;

import com.onlineApp.ENUM.STATUS;
import com.onlineApp.ExceptionHandler.ResourceAlreadyExistException;
import com.onlineApp.ExceptionHandler.ResourceNotFoundException;
import com.onlineApp.Model.Customer;
import com.onlineApp.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customerList = customerService.getAllCustomersService();
        return new ResponseEntity<>(customerList, HttpStatus.FOUND);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            throw new ResourceNotFoundException("Error! Resource with id " + id + " has not found!");
        }
        return new ResponseEntity<>(customer, HttpStatus.FOUND);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<String> addCustomer(@Valid @RequestBody Customer customer) {
        STATUS status = customerService.addCustomer(customer);
        if (status.equals(STATUS.FAIL)) {
            throw new ResourceAlreadyExistException("Duplicate Entry! Resource with Email " + customer.getEmail() + " already exists!");
        }
        return new ResponseEntity<>("Successfully added your data", HttpStatus.CREATED);
    }
}
