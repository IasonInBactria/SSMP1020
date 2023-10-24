package com.argo.service;


import com.argo.domain.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private IBookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }

    @Test
    void testDelete(){
        bookService.removeById(16);
    }

    @Test
    void testGetAll(){
        bookService.list();
    }

    @Test
    void testGetPage(){
        IPage<Book> bookIPage = new Page<Book>(2, 5);
        bookService.page(bookIPage);
        System.out.println(bookIPage.getCurrent());
        System.out.println(bookIPage.getSize());
        System.out.println(bookIPage.getTotal());
        System.out.println(bookIPage.getPages());
        System.out.println(bookIPage.getRecords());
    }
}
