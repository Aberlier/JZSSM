package com.jzssm.fhf.common;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 84644
 * @Date: 2019/4/3 14:02
 * @Description: 返回对象
 **/
public class ResultUtil {
    public static ResultVo success(Object data){
        return new ResultVo(ResultCodeEnum.SUCCESS.getCode(),data,ResultCodeEnum.SUCCESS.getMsg());
    }

    public static ResultVo success(String msg){
        return new ResultVo(ResultCodeEnum.SUCCESS.getCode(),null,msg);
    }

    public static ResultVo error(String msg){
        return new ResultVo(ResultCodeEnum.FAIL.getCode(),null,msg);
    }

    public static Map<String, Object> dataGridEmptyResult() {
        Map<String, Object> result = new HashMap<>();
        result.put("total", 0);
        result.put("rows", Lists.newArrayList());
        return result;
    }
}
