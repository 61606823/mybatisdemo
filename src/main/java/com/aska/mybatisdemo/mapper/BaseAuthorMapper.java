package com.aska.mybatisdemo.mapper;

import com.aska.mybatisdemo.dto.response.AuthorBookBean;
import com.aska.mybatisdemo.entity.BaseAuthor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

public interface BaseAuthorMapper {
    /**
     * 新增用户
     *
     * @param author
     */
    @Insert("insert into base_author(id, name, age, create_time) values(#{id}, #{name}, #{age}, #{createTime})")
    void insertAuthor(BaseAuthor author);

    /**
     * 查询单个用户
     * org.apache.ibatis.builder.annotation.MapperAnnotationBuilder#getSqlSourceFromAnnotations(java.lang.reflect.Method, java.lang.Class, org.apache.ibatis.scripting.LanguageDriver)
     *
     * @param id 用户Id
     * @return
     */
    @Select("select id, name, age, create_time from base_author where id = #{id}")
    Optional<BaseAuthor> selectAuthor(String id);

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select id, name, age, create_time from base_author")
    List<BaseAuthor> selectAuthors();

    /**
     * 更新单个用户
     *
     * @param author
     */
    @Update("Update base_author set name = #{name}, age = #{age} where id = #{id}")
    void updateAuthor(BaseAuthor author);

    /**
     * 删除单个用户
     *
     * @param id 用户Id
     */
    @Delete("delete from base_author where id = #{id}")
    int deleteAuthor(String id);

    /**
     * 查询用户的书籍
     *
     * @param bookName 书籍名称
     * @return
     */
    List<AuthorBookBean> selectAuthorBooks(String bookName);
}
