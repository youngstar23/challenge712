package com.yang.basic.serializable.jackson;

import lombok.Data;

@Data
public class ResultVO<T> {

    private Boolean success = Boolean.TRUE;
    private T data;

    private ResultVO(){

    }

    public static <T> ResultVO<T> buildSuccess(T t){
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setData(t);
        return resultVO;
    }
}
