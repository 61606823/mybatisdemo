package com.aska.mybatisdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.aska.mybatisdemo.common.dataSource.DataBaseType;
import com.aska.mybatisdemo.common.dataSource.DatabaseContextHolder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    @Autowired
    private Environment env;

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource() {
        return new DruidDataSource();
    }

    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Bean
    public DatabaseContextHolder dataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                            @Qualifier("slaveDataSource") DataSource slaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataBaseType.master, masterDataSource);
        targetDataSources.put(DataBaseType.slave, slaveDataSource);

        DatabaseContextHolder dataSource = new DatabaseContextHolder();
        //该方法是AbstractRoutingDataSource的方法
        dataSource.setTargetDataSources(targetDataSources);
        //默认的datasource设置为primaryDataSource
        dataSource.setDefaultTargetDataSource(masterDataSource);

        return dataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DatabaseContextHolder ds) throws Exception {
        SqlSessionFactoryBean sqlSession = new SqlSessionFactoryBean();
        sqlSession.setDataSource(ds);

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //自动使用驼峰命名属性映射字段（userId -> user_id）
        configuration.setMapUnderscoreToCamelCase(true);

        sqlSession.setConfiguration(configuration);
        sqlSession.setFailFast(true);

        //添加Xml目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        try {
            sqlSession.setMapperLocations(resolver.getResources("classpath:mapper/*/*.xml"));

            return sqlSession.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DatabaseContextHolder dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
