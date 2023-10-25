package com.argo.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YangY
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Boolean flag;
    private Object data;
    String message;

    public Result(Boolean flag){
        this.flag = flag;
    }

    public Result(String message){
        this.flag = false;
        this.message = message;
    }

    public Result(Boolean flag, Object data){
        this.flag = flag;
        this.data = data;
    }
}
