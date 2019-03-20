package com.aska.mybatisdemo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuthorBean {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
}
