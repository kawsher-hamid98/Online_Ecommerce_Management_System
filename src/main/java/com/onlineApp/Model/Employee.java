package com.onlineApp.Model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_id")
    @SequenceGenerator(name = "employee_id", initialValue = 2000, sequenceName = "employee_id_generator")
    private long id;
    @Valid
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name", length = 30)),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name", length = 30))
    })
    private NameSection nameSection;
    @Email
    @Column(name = "employee_email", unique = true)
    @Size(min = 8, max = 30, message = "Email size must be between 8 to 30 characters")
    private String email;
    @Column(name = "employee_salary")
    @Min(1)
    @Max(100000)
    private int salary;

}
