package com.rupamhari.employeesystembackend.helper;

import com.rupamhari.employeesystembackend.model.Employee;

public class Helper {
    public static void trimEmployee(Employee employee) {
        employee.setFirstName(employee.getFirstName().trim());
        employee.setLastName(employee.getLastName().trim());
        employee.setEmail(employee.getEmail().trim());
    }
}
