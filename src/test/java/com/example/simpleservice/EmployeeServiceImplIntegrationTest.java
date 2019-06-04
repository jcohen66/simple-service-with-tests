package com.example.simpleservice;

import com.example.simpleservice.model.Employee;
import com.example.simpleservice.repository.EmployeeRepository;
import com.example.simpleservice.service.EmployeeService;
import com.example.simpleservice.service.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest {


    /**
     * To check the Service class, we need to have an instance of Service class created and available as
     * a @Bean so that we can @Autowire it in our test class. This configuration is achieved by using the
     * @TestConfiguration annotation.
     */
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }

    }

    @Autowired
    private EmployeeService employeeService;

    /**
     * creates a Mock for the EmployeeRepository which can be used to bypass the call
     * to the actual EmployeeRepository:
     */
    @MockBean
    private EmployeeRepository employeeRepo;

    @Before
    public void setUp() {
        String name = "alex";
        Employee alex =  Employee.builder()
                .name(name)
                .build();

        Mockito.when(employeeRepo.findByName(alex.getName()))
                .thenReturn(alex);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "alex";
        Employee found = employeeService.getEmployeeByName(name);

        assert(found.getName())
                .equals(name);
    }
}
