package com.example.simpleservice.service;

import com.example.simpleservice.model.Employee;
import com.example.simpleservice.repository.EmployeeRepository;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeByName(String name);

    List<Employee> getAllEmployees();
}
