package com.onlineApp.Model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customer_id")
    @SequenceGenerator(name = "customer_id", initialValue = 1000, sequenceName = "customer_id_generator")
    private long id;

    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name", length = 30)),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name", length = 30))
    })
    @Valid
    @Embedded
    private NameSection nameSection;

    @NotNull(message = "Email must not be empty")
    @Column(unique = true)
    @Size(min = 8, max = 30, message = "Email size must be between 8 and 30 characters")
    @Email(message = "Email should be a valid email address")
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NameSection getNameSection() {
        return nameSection;
    }

    public void setNameSection(NameSection nameSection) {
        this.nameSection = nameSection;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", nameSection=" + nameSection +
                ", email='" + email + '\'' +
                '}';
    }
}
