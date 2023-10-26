package com.argo.controller;


import com.argo.domain.Book;
import com.argo.service.IBookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YangY
 */
//@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService iBookService;

    @GetMapping()
    public List<Book> getAll(){
        return iBookService.list();
    }

    @PostMapping()
    public boolean save(@RequestBody Book book){
        return iBookService.saveBook(book);
    }

    @PutMapping
    public boolean update(@RequestBody Book book){
        return iBookService.modify(book);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return iBookService.delete(id);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return iBookService.getById(id);
    }

    @GetMapping("{curPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int curPage, @PathVariable int pageSize){
        Book book = new Book();
        return iBookService.getPage(curPage, pageSize, book);
    }
}
