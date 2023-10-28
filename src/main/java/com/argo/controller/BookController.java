package com.argo.controller;


import com.argo.controller.utils.Result;
import com.argo.dao.BookMapper;
import com.argo.domain.Book;
import com.argo.service.IBookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author YangY
 */
@Slf4j
@RestController
@RequestMapping("/books")

public class BookController {

    @Autowired
    private IBookService iBookService;
    /**
     * 创建记录日志的对象
     */
    @GetMapping()
    public Result getAll(){
        Result result = new Result();
        return new Result(true, iBookService.list());
    }

    @PostMapping()
    public Result save(@RequestBody Book book) throws IOException {
//        Result result = new Result();
//        result.setFlag(iBookService.saveBook(book));
        if (book.getName().equals("123")) {
            throw new IOException();
        }
        boolean flag = iBookService.saveBook(book);
        return new Result(flag, flag? "修改成功^_^": "修改失败-_-!");
    }

    @PutMapping
    public Result update(@RequestBody Book book){
        return new Result(iBookService.modify(book));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result deleteResult = new Result(iBookService.delete(id));
        return deleteResult;
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        return new Result(true, iBookService.getById(id));
    }

    @GetMapping("{curPage}/{pageSize}")
    public Result getPage(@PathVariable int curPage, @PathVariable int pageSize, Book book){
        IPage<Book> iPage = iBookService.getPage(curPage, pageSize, book);
        log.info("get hot deploy!!!!");
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (curPage > iPage.getPages()){
            iPage = iBookService.getPage((int)iPage.getPages(), pageSize, book);
        }
        return new Result(true, iPage);
    }
}
