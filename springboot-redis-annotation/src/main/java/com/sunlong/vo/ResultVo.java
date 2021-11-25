package com.sunlong.vo;

public class ResultVo {
    private int code;
    private String message;
    private String data;

    public ResultVo() {
    }

    public ResultVo(int code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultVo getSuccessResult(String businessResult) {
        return new ResultVo(000000,"success",businessResult);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static ResultVo getFailedResult(int i, String message) {
        return new ResultVo(i,message,null);
    }
}
