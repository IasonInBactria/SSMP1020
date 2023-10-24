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

    public Result(Boolean flag){
        this.flag = flag;
    }
}
