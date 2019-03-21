package com.aska.mybatisdemo.exception;

import com.alibaba.fastjson.JSON;
import com.aska.mybatisdemo.dto.response.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ServiceResult<String> entityNotFoundException(HttpServletRequest request, Exception e) {
        ServiceResult<String> result = new ServiceResult<>();
        result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setMessage(e.getLocalizedMessage());
        result.setData(request.getRequestURL().toString());

        log.error(JSON.toJSONString(result));

        return result;
    }
}
