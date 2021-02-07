package com.jzssm.fhf.common;

/**
 * @Author: 84644
 * @Date: 2019/4/3 14:13
 * @Description:
 **/
public class ResultVo {
    private Integer code;
    private Object data;
    private String msg;

    public ResultVo(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultVo(Object data) {
        this.data = data;
    }
}
