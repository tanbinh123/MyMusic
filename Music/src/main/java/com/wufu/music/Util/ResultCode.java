package com.wufu.music.Util;

/**
 * @author wufu
 * @date 2021/2/7 16:05
 */
public enum ResultCode {
    SUCCESS(200),

    FAIL(400),

    INTERNAL_SERVER_ERROR(500);

    private int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
