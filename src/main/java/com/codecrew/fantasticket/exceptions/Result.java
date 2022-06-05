package com.codecrew.fantasticket.exceptions;

import java.util.Collections;
import java.util.List;

public class Result {
    private boolean success;
    private Object data;
    
    public Result(boolean success,Object data) {
        this.data = data;
        this.success = success;
    }
    
    public static Result response(Object data){
        if(data == null) return new Result(false, Collections.emptyList());
        if(data instanceof Collections) return new Result(true, data);
        else return new Result(true, List.of(data));
    }
    public boolean isSuccess() {
        return this.success;
    }
}