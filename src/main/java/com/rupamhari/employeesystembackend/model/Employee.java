package com.rupamhari.employeesystembackend.model;

import lombok.Data;

@Data
public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
