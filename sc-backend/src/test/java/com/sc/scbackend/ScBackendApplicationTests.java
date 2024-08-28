package com.sc.scbackend;

import cn.hutool.extra.emoji.EmojiUtil;
import com.sc.scbackend.dao.EmployeeDao;
import com.sc.scbackend.domain.Employee;
import com.sc.scbackend.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ScBackendApplication.class)
class ScBackendApplicationTests {

    @Autowired
    EmployeeService es;

    @Autowired
    EmployeeDao edao;

    @Test
    public void EmployeeServiceTest() {
        System.out.println(es.getByAccount("suki"));
        System.out.println(es.getByPhoneNumber("13812345678"));
        Employee e = es.getByAccount("suki");
        e.setName("senbaiiiiii");
        System.out.println(e);
//        es.update(e, null);

        System.out.println(es.getById(e.getId()));

    }
}
