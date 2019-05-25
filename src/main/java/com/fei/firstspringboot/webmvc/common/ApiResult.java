package com.fei.firstspringboot.webmvc.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/5/20
 * @Description: Restful风格前端返回格式定义
 */
@Setter@Getter
public class ApiResult<T> {
    private Integer code;
    private String data;
    private List<T> model;

    /**
     * 响应成功，返回数据
     * @param model List形式的集合数据
     * @return 返回成功的携带数据的结果ApiResult
     */
    public static <T>  ApiResult success(List<T> model){
        ApiResult apiResult = new ApiResult<>();
        apiResult.setCode(200);
        apiResult.setData("请求成功");
        apiResult.setModel(model);
        return apiResult;
    }

    /**
     * 响应成功，返回数据
     * @return 返回成功没有数据的结果ApiResult
     */
    public static <T>  ApiResult succ(){
        ApiResult apiResult = new ApiResult<>();
        apiResult.setCode(200);
        apiResult.setData("操作成功");
        return apiResult;
    }

    /**
     * 响应成功，返回数据
     * @param data 请求失败的原因
     * @return 返回失败原因结果ApiResult
     */
    public static <T>  ApiResult failture(String data){
        ApiResult apiResult = new ApiResult<>();
        apiResult.setCode(500);
        apiResult.setData(data);
        return apiResult;
    }
}
