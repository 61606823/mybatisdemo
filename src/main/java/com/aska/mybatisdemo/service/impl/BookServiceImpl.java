package com.aska.mybatisdemo.service.impl;

import com.aska.mybatisdemo.entity.Book;
import com.aska.mybatisdemo.mapper.BookMapper;
import com.aska.mybatisdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> selectBooks() {
        return bookMapper.selectAll();
    }
}
