package com.aska.mybatisdemo.config;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@MapperScan("com.aska.mybatisdemo.mapper")
public class AppConfig {
    /**
     * PageHelper相关配置
     *
     * @return
     */
    @Bean
    public PageHelper pageHelper() {
        Properties p = new Properties();
        //offsetAsPageNum：设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用.
        p.setProperty("offsetAsPageNum", "true");
        //rowBoundsWithCount：设置为true时，使用RowBounds分页会进行count查询.
        p.setProperty("rowBoundsWithCount", "true");
        //reasonable：启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页。
        p.setProperty("reasonable", "true");
        //配置mysql数据库的方言
        p.setProperty("dialect", "mysql");

        PageHelper pageHelper = new PageHelper();
        pageHelper.setProperties(p);

        return pageHelper;
    }
}
