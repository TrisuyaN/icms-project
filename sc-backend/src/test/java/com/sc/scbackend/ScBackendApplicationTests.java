package com.sc.scbackend;

import com.sc.scbackend.domain.Employee;
import com.sc.scbackend.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ScBackendApplication.class)
class ScBackendApplicationTests {

    @Autowired
    EmployeeService es;

    @Test
    public void getEmployeeByAccountTest() {
        Employee e = es.getByAccount("zhangsan");
        System.out.println(e.toString());
    }
}
