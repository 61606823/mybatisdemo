package com.aska.mybatisdemo.aop;

import com.aska.mybatisdemo.common.dataSource.DatabaseContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {
    @Before("(@annotation(com.aska.mybatisdemo.annotation.Master) " +
            "|| execution(* com.aska.mybatisdemo.mapper..*.insert*(..)) " +
            "|| execution(* com.aska.mybatisdemo.mapper..*.update*(..)) " +
            "|| execution(* com.aska.mybatisdemo.mapper..*.delete*(..)) " +
            "|| execution(* com.aska.mybatisdemo.mapper..*.add*(..))) " +
            "&& !@annotation(com.aska.mybatisdemo.annotation.Slave)")
    public void setMasterDataSourceType() {
        DatabaseContextHolder.setMaster();
    }

    @Before("(@annotation(com.aska.mybatisdemo.annotation.Slave) " +
            "|| execution(* com.aska.mybatisdemo.mapper..*.query*(..)) " +
            "|| execution(* com.aska.mybatisdemo.mapper..*.select*(..)) " +
            "|| execution(* com.aska.mybatisdemo.mapper..*.get*(..))) " +
            "&& !@annotation(com.aska.mybatisdemo.annotation.Master)")
    public void setSlaveDataSourceType() {
        DatabaseContextHolder.setSlave();
    }
}
