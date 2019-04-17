package com.aska.mybatisdemo.mapper;

import com.aska.mybatisdemo.dto.response.AuthorBookBean;
import com.aska.mybatisdemo.entity.Author;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

public interface AuthorMapper {
    /**
     * 新增用户
     *
     * @param author
     */
    @Insert("insert into author(id, name, age, create_time) values(#{id}, #{name}, #{age}, #{createTime})")
    void insertAuthor(Author author);

    /**
     * 查询单个用户
     *
     * @param id 用户Id
     * @return
     */
    @Select("select id, name, age, create_time from author where id = #{id}")
    Optional<Author> selectAuthor(String id);

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select id, name, age, create_time from author")
    List<Author> selectAuthors();

    /**
     * 更新单个用户
     *
     * @param author
     */
    @Update("Update author set name = #{name}, age = #{age} where id = #{id}")
    void updateAuthor(Author author);

    /**
     * 删除单个用户
     *
     * @param id 用户Id
     */
    @Delete("delete from author where id = #{id}")
    int deleteAuthor(String id);

    /**
     * 查询用户的书籍
     *
     * @param bookName 书籍名称
     * @return
     */
    List<AuthorBookBean> selectAuthorBooks(String bookName);
}
