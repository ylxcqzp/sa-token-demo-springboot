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
public class CommonResult<T> {
    private int status;

    private String message;

    private T data;

    private long timestamp;

    public CommonResult(){
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> CommonResult<T> success(String message) {
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.setStatus(ReturnCode.RC100.getCode());
        commonResult.setMessage(message);
        return commonResult;
    }

    public static <T> CommonResult<T> success() {
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.setStatus(ReturnCode.RC100.getCode());
        commonResult.setMessage("操作成功");
        return commonResult;
    }

    public static <T> CommonResult<T> fail(int code, String message) {
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.setStatus(code);
        commonResult.setMessage(message);
        return commonResult;
    }

}
