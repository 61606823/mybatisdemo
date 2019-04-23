package com.aska.mybatisdemo.service.impl;

import com.aska.mybatisdemo.dto.response.AuthorBookBean;
import com.aska.mybatisdemo.entity.BaseAuthor;
import com.aska.mybatisdemo.mapper.BaseAuthorMapper;
import com.aska.mybatisdemo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private BaseAuthorMapper authorMapper;

    @Override
    @Transactional
    public void insertAuthor(BaseAuthor author) {
        authorMapper.insertAuthor(author);

        //int i = 10 / 0;
    }

    @Override
    public Optional<BaseAuthor> selectAuthor(String id) {
        return authorMapper.selectAuthor(id);
    }

    @Override
    public List<BaseAuthor> selectAuthors() {
        return authorMapper.selectAuthors();
    }

    @Override
    public void updateAuthor(BaseAuthor author) {
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
