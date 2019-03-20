package com.aska.mybatisdemo.service;

import com.aska.mybatisdemo.dto.response.AuthorBookBean;
import com.aska.mybatisdemo.entity.Author;

import java.util.List;

public interface AuthorService {
    /**
     * 新增用户
     *
     * @param author
     */
    void insertAuthor(Author author);

    /**
     * 查询单个用户
     *
     * @param id 用户Id
     * @return
     */
    Author selectAuthor(String id);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<Author> selectAuthors();

    /**
     * 更新单个用户
     *
     * @param author
     */
    void updateAuthor(Author author);

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
