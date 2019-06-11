package com.example.simpleservice.service;

import com.example.simpleservice.model.Employee;
import com.example.simpleservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
        employees.add(Employee.builder()
                .id(1L)
            .name("Tom")
                .build()
        );

        employees.add(Employee.builder()
                .id(2L)
                .name("Bill")
                .build()
        );

    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getAllEmployees() {

        return employees;
    }


}
