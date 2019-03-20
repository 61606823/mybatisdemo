package com.aska.mybatisdemo.service.impl;

import com.aska.mybatisdemo.dto.response.AuthorBookBean;
import com.aska.mybatisdemo.entity.Author;
import com.aska.mybatisdemo.mapper.AuthorMapper;
import com.aska.mybatisdemo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorMapper authorMapper;

    @Override
    @Transactional
    public void insertAuthor(Author author) {
        authorMapper.insertAuthor(author);

        //int i = 10 / 0;
    }

    @Override
    public Author selectAuthor(String id) {
        return authorMapper.selectAuthor(id);
    }

    @Override
    public List<Author> selectAuthors() {
        return authorMapper.selectAuthors();
    }

    @Override
    public void updateAuthor(Author author) {
        authorMapper.updateAuthor(author);
    }

    @Override
    public int deleteAuthor(String id) {
        return authorMapper.deleteAuthor(id);
    }

    @Override
    public List<AuthorBookBean> selectAuthorBooks(String bookName) {
        return authorMapper.selectAuthorBooks(bookName);
    }
}
