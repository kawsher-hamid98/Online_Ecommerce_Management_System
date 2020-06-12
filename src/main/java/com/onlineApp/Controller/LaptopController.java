//package com.onlineApp.Controller;
//
//import com.onlineApp.ENUM.STATUS;
//import com.onlineApp.ExceptionHandler.ResourceAlreadyExistException;
//import com.onlineApp.ExceptionHandler.ResourceNotFoundException;
//import com.onlineApp.Model.Laptop;
//import com.onlineApp.Service.LaptopService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//@RestController
//public class LaptopController {
//
//    public LaptopService laptopService;
//
//    @Autowired
//    public LaptopController(LaptopService laptopService) {
//        this.laptopService = laptopService;
//    }
//
//    @RequestMapping(value = "/customers/{id}/laptop", method = RequestMethod.POST)
//    public ResponseEntity<String> addLaptop(@PathVariable Long id, @RequestBody Laptop laptop) {
//        STATUS status = laptopService.addLaptop(id, laptop);
//        if (status == STATUS.FAIL){
//            throw new ResourceAlreadyExistException("Customer with id " + id + " has not found");
//        }
//        return new ResponseEntity<>("Successfully added", HttpStatus.CREATED);
//    }
//
//    @RequestMapping(value = "/customers/{id}/laptops", method = RequestMethod.GET)
//    public ResponseEntity<List<Laptop>> getAllLaptop(HttpServletResponse response, @PathVariable Long id) {
//        List<Laptop> laptopList = laptopService.getAllLaptop(id);
//        int size = laptopList.size();
//        System.out.println("size " + size);
//        if (size < 1) {
//            throw new ResourceNotFoundException("No laptop found against id " + id);
//        }
//        response.addHeader("List size", String.valueOf(size));
//        return new ResponseEntity<>(laptopList, HttpStatus.OK);
//    }
//}
