package com.onlineApp.Service;

import com.onlineApp.ENUM.STATUS;
import com.onlineApp.Model.Employee;
import com.onlineApp.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllCustomersService() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee getCustomerById(long id) {
        Optional<Employee> customer = employeeRepository.findById(id);
        return customer.orElse(null);
    }

//    public STATUS addCustomer(Employee employee) {
//        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
//            return STATUS.FAIL;
//        }
//        employeeRepository.save(employee);
//        return STATUS.SUCCESS;
//    }
}
