package com.aska.mybatisdemo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResult<T> {
    /**
     * 状态码
     */
    private int status = 200;
    /**
     * 消息
     */
    private String message = "SUCCESS";
    /**
     * 数据
     */
    private T data;
}
