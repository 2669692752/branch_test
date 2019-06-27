package com.jm.test.utils;


import io.swagger.annotations.ApiModelProperty;

/**
 * @param <T>
 * @author lyx
 * @ClassName: APIResponse
 * @Description: TODO(此类为Controller返回值)
 * @date 2018/5/25
 */
public class APIResponse<T> {
    @ApiModelProperty(value = "返回码，100为成功，其他为失败，错误原因见msg")
    private int code;


    @ApiModelProperty(value = "操作是否成功")
    private boolean optSuc = true;

    @ApiModelProperty(value = "操作失败时的提示信息")
    private String msg;

    @ApiModelProperty(value = "返回结果")
    private T data;

    /**
     * Description: 构造方法
     *
     * @param code   返回值代码
     * @param optSuc 是否操作成功
     * @param msg    返回信息
     * @param data   返回的数据
     */
    public APIResponse(int code, boolean optSuc, String msg, T data) {
        this.code = code;
        this.optSuc = optSuc;
        this.msg = msg;
        this.data = data;
    }

    public APIResponse() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isOptSuc() {
        return optSuc;
    }

    public void setOptSuc(boolean optSuc) {
        this.optSuc = optSuc;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
 
