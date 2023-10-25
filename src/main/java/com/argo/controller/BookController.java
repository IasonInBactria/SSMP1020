package com.argo.controller;


import com.argo.controller.utils.Result;
import com.argo.dao.BookMapper;
import com.argo.domain.Book;
import com.argo.service.IBookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YangY
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping()
    public Result getAll(){
        Result result = new Result();
        return new Result(true, iBookService.list());
    }

    @PostMapping()
    public Result save(@RequestBody Book book){
//        Result result = new Result();
//        result.setFlag(iBookService.saveBook(book));
        return new Result(iBookService.saveBook(book));
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
    public Result getPage(@PathVariable int curPage, @PathVariable int pageSize){
        return new Result(true, iBookService.getPage(curPage, pageSize));
    }
}
