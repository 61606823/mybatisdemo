package com.aska.mybatisdemo.service;

import com.aska.mybatisdemo.dto.response.AuthorBookBean;
import com.aska.mybatisdemo.entity.BaseAuthor;

import java.util.List;

public interface AuthorService {
    /**
     * 新增用户
     *
     * @param author
     */
    void insertAuthor(BaseAuthor author);

    /**
     * 查询单个用户
     *
     * @param id 用户Id
     * @return
     */
    BaseAuthor selectAuthor(String id) throws Throwable;

    /**
     * 查询所有用户
     *
     * @return
     */
    List<BaseAuthor> selectAuthors();

    /**
     * 更新单个用户
     *
     * @param author
     */
    void updateAuthor(BaseAuthor author);

    /**
     * 删除单个用户
     *
     * @param id 用户Id
     */
    int deleteAuthor(String id);

    /**
     * 查询用户的书籍
     *
     * @param bookName 书籍名称
     * @return
     */
    List<AuthorBookBean> selectAuthorBooks(String bookName);
}
