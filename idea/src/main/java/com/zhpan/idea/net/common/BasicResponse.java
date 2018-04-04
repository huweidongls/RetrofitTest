package com.zhpan.idea.net.common;

/**
 *
 */
public class BasicResponse<T> {

    /**
     * code : 0
     * msg : {"info":"fail!","name":"123","pwd":"456"}
     */

    private int code;
    private T msg;

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
