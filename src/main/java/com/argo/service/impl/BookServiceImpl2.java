package com.argo.service.impl;

import com.argo.dao.BookMapper;
import com.argo.domain.Book;
import com.argo.service.BookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author YangY
 */
@Service
public class BookServiceImpl2 implements BookService {

    @Autowired
    private BookMapper bookMapper;
    /**
     * @param book
     * @return
     */
    @Override
    public boolean save(Book book) {
        return bookMapper.insert(book) > 0;
    }

    /**
     * @param book
     * @return
     */
    @Override
    public boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    /**
     * @return
     */
    @Override
    public Book getById(Integer id) {
        return bookMapper.selectById(id);
    }

    /**
     * @return
     */
    @Override
    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }

    /**
     * @param curPage
     * @param pageSize
     * @return
     */
    @Override
    public IPage<Book> getPage(int curPage, int pageSize) {
        IPage<Book> bookIPage = new Page<>(curPage, pageSize);
        return bookMapper.selectPage(bookIPage, null);
    }
}
