package com.aska.mybatisdemo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Api工具类
 */
@Slf4j
public class ApiUtil {
    /**
     * 字符串 转换成 数字类型
     *
     * @param str     输入字符串
     * @param nullVal 默认值
     * @return int
     */
    public static int str2Int(String str, int nullVal) {
        int result = nullVal;

        try {
            if (StringUtils.isNotEmpty(str) && StringUtils.isNumeric(str)) {
                result = Integer.parseInt(str);
            }
        } catch (Exception e) {
            log.error("Integer.parseInt() str is not a number:{}", str);
        }

        return result;
    }
}
