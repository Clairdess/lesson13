package com.vkatit;

import com.vkatit.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @LocalServerPort
    int randomPort;
    RestTemplate restTemplate;

    @BeforeEach
    public void init() {
        restTemplate = new RestTemplate();
    }

    @Autowired
    Environment environment;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test(){
        EmployeeRepository repository = applicationContext.getBean("employeeRepository", EmployeeRepository.class);
        if (repository.getAllEmployees().size() > 0){
            System.out.println("OK");
        } else throw new RuntimeException();
    }
}

