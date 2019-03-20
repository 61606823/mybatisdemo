package com.aska.mybatisdemo.mapper;

import com.aska.mybatisdemo.entity.Book;
import java.util.List;

public interface BookMapper {
    int insert(Book record);

    List<Book> selectAll();
}