package com.argo;

import com.argo.dao.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ssmp1020ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private BookMapper bookMapper;

    @Test
    void testGetById(){
        System.out.println(bookMapper.selectById(1));
    }

}
