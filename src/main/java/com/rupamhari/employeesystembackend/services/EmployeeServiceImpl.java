package com.rupamhari.employeesystembackend.services;

import com.rupamhari.employeesystembackend.entity.EmployeeEntity;
import com.rupamhari.employeesystembackend.model.Employee;
import com.rupamhari.employeesystembackend.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        //converting List<EmployeeEntity> to  List<Employee>
        List<Employee> employees = employeeRepository.findAll().stream()
                .map(empEty -> new Employee(
                        empEty.getId(),
                        empEty.getFirstName(),
                        empEty.getLastName(),
                        empEty.getEmail()))
                .collect(Collectors.toList());

        return employees;
    }

    @Override
    public Employee deleteEmployee(long id) {
        EmployeeEntity ee = employeeRepository.findById(id).get();
        employeeRepository.delete(ee);
        Employee e = new Employee();
        BeanUtils.copyProperties(ee, e);
        return e;
    }

    @Override
    public Employee getEmployee(long id) {
        EmployeeEntity ee = employeeRepository.findById(id).get();
        Employee e = new Employee();
        BeanUtils.copyProperties(ee, e);
        return e;
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        EmployeeEntity ee = employeeRepository.findById(id).get();
        ee.setFirstName(employee.getFirstName());
        ee.setLastName(employee.getLastName());
        ee.setEmail(employee.getEmail());
        employeeRepository.save(ee);

        Employee e = new Employee();
        BeanUtils.copyProperties(ee, e);
        return e;

    }
}
