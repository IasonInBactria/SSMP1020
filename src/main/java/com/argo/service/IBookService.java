package com.argo.service;

import com.argo.domain.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author YangY
 */
public interface IBookService extends IService<Book> {
    boolean saveBook(Book book);
    boolean modify(Book book);
    boolean delete(Integer id);

    IPage<Book> getPage(int curPage, int pageSize, Book book);
    IPage<Book> getPage(int curPage, int pageSize);
}
