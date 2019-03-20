package com.aska.mybatisdemo.controller;

import com.aska.mybatisdemo.common.Constants;
import com.aska.mybatisdemo.util.ApiUtil;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {
    /**
     * 开始分页
     *
     * @param request
     */
    protected void startPage(HttpServletRequest request) {
        startPage(request, StringUtils.defaultString(request.getParameter(Constants.PARAM_NAME_ORDERBY), "create_time"));
    }

    /**
     * 开始分页
     *
     * @param request
     * @param orderBy 排序
     */
    protected void startPage(HttpServletRequest request, String orderBy) {
        //页码
        int pageNum = ApiUtil.str2Int(request.getParameter(Constants.PARAM_NAME_PAGENUM), 1);
        //每页显示数量
        int pageSize = ApiUtil.str2Int(request.getParameter(Constants.PARAM_NAME_PAGESIZE), Constants.DEFAULT_PAGESIZE);
        String direction = StringUtils.defaultString(request.getParameter(Constants.PARAM_NAME_DIRECTION), "asc");

        if (pageSize > 100) {
            pageSize = 100;
        }

        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(pageNum, pageSize, String.format("%s %s", orderBy, direction));
    }
}
