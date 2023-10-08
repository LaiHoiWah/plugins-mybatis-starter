package com.meowu.plugins.mybatis.commons.security.exception;

import com.meowu.commons.common.security.exception.MeowuException;

public class ReflectionException extends MeowuException{

    public ReflectionException(){
        super();
    }

    public ReflectionException(String message){
        super(message);
    }

    public ReflectionException(Throwable cause){
        super(cause);
    }

    public ReflectionException(String message, Throwable cause){
        super(message, cause);
    }

    public ReflectionException(String message, Object... args){
        super(String.format(message, args));
    }

    public ReflectionException(Throwable cause, String message, Object... args){
        super(String.format(message, args), cause);
    }
}
