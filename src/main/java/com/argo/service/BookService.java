package com.argo.service;

import com.argo.domain.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @author YangY
 */



public interface BookService {
    /**
     *
     * @param book
     * @return
     */
    boolean save(Book book);
    boolean update(Book book);
    boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    IPage<Book> getPage(int curPage, int pageSize);
}
