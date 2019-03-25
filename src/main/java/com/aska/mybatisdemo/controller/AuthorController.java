package com.aska.mybatisdemo.controller;

import com.aska.mybatisdemo.dto.request.CreateAuthorBean;
import com.aska.mybatisdemo.dto.request.UpdateAuthorBean;
import com.aska.mybatisdemo.dto.response.AuthorBookBean;
import com.aska.mybatisdemo.dto.response.ServiceResult;
import com.aska.mybatisdemo.entity.Author;
import com.aska.mybatisdemo.exception.ApiException;
import com.aska.mybatisdemo.service.AuthorService;
import com.github.pagehelper.PageInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "/author")
public class AuthorController extends BaseController {
    @Autowired
    private AuthorService authorService;

    /**
     * 新增用户
     *
     * @param request
     * @param bean
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void insertAuthor(HttpServletRequest request, @RequestBody CreateAuthorBean bean) {
        ModelMapper modelMapper = new ModelMapper();

        Author author = modelMapper.map(bean, Author.class);
        author.setId(UUID.randomUUID().toString());
        author.setCreateTime(new Date());

        authorService.insertAuthor(author);
    }

    /**
     * 查询单个用户
     *
     * @param request
     * @param id      用户Id
     * @return
     */
    @GetMapping("/detail/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ServiceResult<Author> selectAuthor(HttpServletRequest request, @PathVariable String id) {
        Author author = authorService.selectAuthor(id);

        if (author == null) {
            throw new ApiException(String.format("id：%s无效", id));
        }

        ServiceResult<Author> result = new ServiceResult<>();
        result.setData(author);

        return result;
    }

    /**
     * 查询所有用户
     *
     * @param request
     * @return
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ServiceResult<PageInfo<Author>> selectAuthors(HttpServletRequest request) {
        startPage(request);

        PageInfo<Author> info = new PageInfo<>(authorService.selectAuthors());

        ServiceResult<PageInfo<Author>> result = new ServiceResult<>();
        result.setData(info);

        return result;
    }

    /**
     * 更新单个用户
     *
     * @param request
     * @param id      用户Id
     * @param bean
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(HttpServletRequest request, @PathVariable String id, @RequestBody UpdateAuthorBean bean) {
        Author author = authorService.selectAuthor(id);

        if (author == null) {
            throw new ApiException(String.format("id：%s无效", id));
        }

        author.setName(bean.getName());
        author.setAge(bean.getAge());

        authorService.updateAuthor(author);
    }

    /**
     * 删除单个用户
     *
     * @param request
     * @param id      用户Id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(HttpServletRequest request, @PathVariable String id) {
        int count = authorService.deleteAuthor(id);

        if (count == 0) {
            throw new ApiException(String.format("id：%s无效", id));
        }
    }

    /**
     * 查询用户的书籍
     *
     * @param request
     * @param bookName 书籍名称
     * @return
     */
    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public ServiceResult<PageInfo<AuthorBookBean>> selectAuthorBooks(HttpServletRequest request, @RequestParam(defaultValue = "") String bookName) {
        startPage(request, "a.name");

        PageInfo<AuthorBookBean> info = new PageInfo<>(authorService.selectAuthorBooks(bookName));

        ServiceResult<PageInfo<AuthorBookBean>> result = new ServiceResult<>();
        result.setData(info);

        return result;
    }
}
