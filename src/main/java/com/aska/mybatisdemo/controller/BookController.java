package com.aska.mybatisdemo.controller;

import com.aska.mybatisdemo.dto.response.ServiceResult;
import com.aska.mybatisdemo.entity.BaseBook;
import com.aska.mybatisdemo.service.BookService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/book")
@Slf4j
public class BookController extends BaseController {
    @Autowired
    private BookService bookService;

    /**
     * 查询所有书籍
     *
     * @param request
     * @return
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ServiceResult<PageInfo<BaseBook>> selectBooks(HttpServletRequest request) {
        log.info("{}-{}", request.getMethod(), request.getRequestURI());

        startPage(request);

        PageInfo<BaseBook> info = new PageInfo<>(bookService.selectBooks());

        ServiceResult<PageInfo<BaseBook>> result = new ServiceResult<>();
        result.setData(info);

        return result;
    }
}
