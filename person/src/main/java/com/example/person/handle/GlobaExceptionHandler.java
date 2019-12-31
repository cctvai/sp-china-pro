package com.example.person.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class GlobaExceptionHandler {

    @ExceptionHandler(value =Exception.class )
    @ResponseBody
    public Map<String,Object> exceptionHandler(HttpServletRequest request,Exception e){
        Map<String,Object> handlerMap=new HashMap<>();
        handlerMap.put("success",false);
        handlerMap.put("errMsg",e.getMessage());
        return handlerMap;
    }

}
