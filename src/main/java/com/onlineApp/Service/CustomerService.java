package com.onlineApp.Service;

import com.onlineApp.ENUM.STATUS;
import com.onlineApp.Model.Customer;
import com.onlineApp.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomersService() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer getCustomerById(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    public STATUS addCustomer(Customer customer) {
        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
            return STATUS.FAIL;
        }
        customerRepository.save(customer);
        return STATUS.SUCCESS;
    }
}
