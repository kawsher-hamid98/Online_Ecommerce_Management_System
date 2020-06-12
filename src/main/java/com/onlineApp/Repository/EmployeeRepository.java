package com.onlineApp.Repository;

import com.onlineApp.Model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}
