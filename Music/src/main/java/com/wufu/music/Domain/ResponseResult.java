package com.wufu.music.Domain;

import com.wufu.music.Util.ResultCode;

/**
 * @author wufu
 * @date 2021/2/7 16:09
 */
public class ResponseResult<T> {
    public int code;

    private String msg;

    private T data;

    public ResponseResult<T> setCode(ResultCode resultCode){
        this.code = resultCode.getCode();
        return this;
    }

    public int getCode(){
        return code;
    }

    public ResponseResult<T> setCode(int code){
        this.code = code;
        return this;
    }

    public String getMsg(){
        return msg;
    }

    public ResponseResult<T> setMsg(String msg){
        this.msg = msg;
        return this;
    }

    public T getData(){
        return data;
    }

    public ResponseResult<T> setData(T data){
        this.data = data;
        return this;
    }
}
