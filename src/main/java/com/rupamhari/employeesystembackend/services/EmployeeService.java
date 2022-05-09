package com.rupamhari.employeesystembackend.services;

import com.rupamhari.employeesystembackend.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee deleteEmployee(long id);
}
