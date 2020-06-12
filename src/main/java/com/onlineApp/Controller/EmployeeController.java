package com.onlineApp.Controller;

import com.onlineApp.ENUM.STATUS;
import com.onlineApp.ExceptionHandler.ResourceAlreadyExistException;
import com.onlineApp.ExceptionHandler.ResourceNotFoundException;
import com.onlineApp.Model.Employee;
import com.onlineApp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getCustomers() {
        List<Employee> customerList = employeeService.getAllCustomersService();
        return new ResponseEntity<>(customerList, HttpStatus.FOUND);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getCustomerById(@PathVariable long id) {
        Employee employee = employeeService.getCustomerById(id);
        if (employee == null) {
            throw new ResourceNotFoundException("Error! Resource with id " + id + " has not found!");
        }
        return new ResponseEntity<>(employee, HttpStatus.FOUND);
    }

//    @PostMapping(value = "/employees")
//    public ResponseEntity<String> addCustomer(@Valid @RequestBody Employee employee) {
//        STATUS status = employeeService.addCustomer(employee);
//        if (status.equals(STATUS.FAIL)) {
////            throw new ResourceAlreadyExistException("Duplicate Entry! Resource with Email " + employee.getEmail() + " already exists!");
//        }
//        return new ResponseEntity<>("Successfully added your data", HttpStatus.CREATED);
//    }
}
