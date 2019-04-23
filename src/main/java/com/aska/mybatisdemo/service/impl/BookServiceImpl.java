package com.aska.mybatisdemo.service.impl;

import com.aska.mybatisdemo.entity.BaseBook;
import com.aska.mybatisdemo.mapper.BaseBookMapper;
import com.aska.mybatisdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BaseBookMapper baseBookMapper;

    @Override
    public List<BaseBook> selectBooks() {
        return baseBookMapper.selectAll();
    }
}
