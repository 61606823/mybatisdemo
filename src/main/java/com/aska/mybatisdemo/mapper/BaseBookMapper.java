package com.aska.mybatisdemo.mapper;

import com.aska.mybatisdemo.entity.BaseBook;
import java.util.List;

public interface BaseBookMapper {
    int insert(BaseBook record);

    List<BaseBook> selectAll();
}