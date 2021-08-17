package com.example.demo.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author qzp
 * @Description: 接口统一返回格式
 * @date 2021/8/17 9:55
 */
@Data
@Accessors(chain = true)
public class ResultData<T> {
    private int status;

    private String message;

    private T data;

    private long timestamp;

    public ResultData(){
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ReturnCode.RC100.getCode());
        resultData.setMessage(message);
        return resultData;
    }

    public static <T> ResultData<T> fail(int code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(code);
        resultData.setMessage(message);
        return resultData;
    }
}
