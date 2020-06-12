//package com.onlineApp.Service;
//
//import com.onlineApp.ENUM.STATUS;
//import com.onlineApp.Model.Customer;
//import com.onlineApp.Model.Laptop;
//import com.onlineApp.Repository.CustomerRepository;
//import com.onlineApp.Repository.LaptopRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class LaptopService {
//    private final LaptopRepository laptopRepository;
//    private final CustomerRepository customerRepository;
//
//    @Autowired
//    public LaptopService(LaptopRepository laptopRepository, CustomerRepository customerRepository) {
//        this.laptopRepository = laptopRepository;
//        this.customerRepository = customerRepository;
//    }
//
//    public STATUS addLaptop(long id, Laptop laptop) {
//        Optional<Customer> customer = customerRepository.findById(id);
//        if (customer.isPresent()) {
//            laptop.setCustomer(customer.get());
//            laptopRepository.save(laptop);
//            return STATUS.SUCCESS;
//        }
//        return STATUS.FAIL;
//    }
//
//    public List<Laptop> getAllLaptop(long id) {
//        return laptopRepository.findAllLaptopByUserId(id);
//    }
//}
