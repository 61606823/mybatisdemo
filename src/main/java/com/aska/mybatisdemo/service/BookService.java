package com.aska.mybatisdemo.service;

import com.aska.mybatisdemo.entity.BaseBook;

import java.util.List;

public interface BookService {
    /**
     * 查询所有书籍
     *
     * @return
     */
    List<BaseBook> selectBooks();
}
