package com.argo;

import com.argo.dao.BookMapper;
import com.argo.domain.Book;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void testGetAll(){
        System.out.println(bookMapper.selectList(null));
    }

    @Test
    void testGetPage(){
        IPage iPage = new Page(2, 5);
        bookMapper.selectPage(iPage, null);
        System.out.println(iPage.getCurrent());
        System.out.println(iPage.getSize());
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getPages());
        System.out.println(iPage.getRecords());
    }

    @Test
    void testGetBy(){
//        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
//        bookQueryWrapper.like("name", "Spring");
//        List<Book> bookList = bookMapper.selectList(bookQueryWrapper);
//        for (Book bookItem:
//             bookList) {
//            System.out.println(bookItem);
//        }
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Book::getName, "Spring");
        List<Book> bookList = bookMapper.selectList(lambdaQueryWrapper);
        bookList.forEach(System.out::println);
    }

}
