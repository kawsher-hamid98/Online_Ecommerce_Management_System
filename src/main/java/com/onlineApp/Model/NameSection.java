package com.onlineApp.Model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class NameSection {
    @NotNull(message = "First Name must not be empty")
    @Size(min = 3, max = 30, message = "First Name size must be between 3 and 30")
    private String firstName;

    @NotNull(message = "Last Name must not be empty")
    @Size(min = 3, max = 30, message = "Last Name size must be between 3 and 30")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "NameSection{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}