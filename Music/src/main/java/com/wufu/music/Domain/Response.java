package com.wufu.music.Domain;

import com.wufu.music.Util.ResultCode;

/**
 * @author wufu
 * @date 2021/2/7 17:16
 */
public class Response {
    private final static String SUCCESS = "success";
    private final static String FAIL = "fail";

    public static <T> ResponseResult<T> makeOkRsp(){
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> ResponseResult<T> makeOkRsp(String message){
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS).setMsg(message);
    }

    public static <T> ResponseResult<T> makeOkRsp(T data){
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> ResponseResult<T> makeErrorRsp(){
        return new ResponseResult<T>().setCode(ResultCode.FAIL).setMsg(FAIL);
    }

    public static <T> ResponseResult<T> makeErrorRsp(String message){
        return new ResponseResult<T>().setCode(ResultCode.FAIL).setMsg(message);
    }

    public static <T> ResponseResult<T> makeErrorRsp(T data){
        return new ResponseResult<T>().setCode(ResultCode.FAIL).setMsg(FAIL).setData(data);
    }
}
