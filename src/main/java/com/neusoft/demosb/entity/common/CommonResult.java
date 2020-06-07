package com.neusoft.demosb.entity.common;

import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 9:37 2020/5/28
 */
public class CommonResult<T> {
    private int code;
    private String msg;
    private Long count;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
