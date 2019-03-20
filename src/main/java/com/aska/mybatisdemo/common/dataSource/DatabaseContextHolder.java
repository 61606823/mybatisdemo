package com.aska.mybatisdemo.common.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 提供一个线程安全的DataBaseType容器
 * 使用DatabaseContextHolder获取当前线程的DatabaseType
 */
public class DatabaseContextHolder extends AbstractRoutingDataSource {
    private static final ThreadLocal<DataBaseType> contextHolder = new ThreadLocal<>();

    public static void setMaster() {
        contextHolder.set(DataBaseType.master);
    }

    public static void setSlave() {
        contextHolder.set(DataBaseType.slave);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return contextHolder.get();
    }
}
