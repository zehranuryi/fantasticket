package com.codecrew.fantasticket.exceptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Result<T extends Object> {
    private Boolean success;
    private T data;
    
    public Result(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }
    
    public static Object response(Object data){
        if(data == null) return new Result(false, new ArrayList<>());
        if(data instanceof Collection) return new Result(true, data);
        return new Result(true,  data);
    }
    
    public Boolean getSuccess() {
        return success;
    }
    
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
}