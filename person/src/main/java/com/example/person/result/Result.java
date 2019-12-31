package com.example.person.result;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;
    private T data;
    private String msg;

    public Result(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }


}
