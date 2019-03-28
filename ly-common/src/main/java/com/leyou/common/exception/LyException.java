package com.leyou.common.exception;

import com.leyou.common.enums.ExceptionEnums;

/**
 * @author xubing
 * @date 2019/3/18
 */
public class LyException extends RuntimeException {
    private ExceptionEnums exceptionEnums;

    public LyException(){}

    public LyException(ExceptionEnums exceptionEnums){
        this.exceptionEnums = exceptionEnums;
    }

    public ExceptionEnums getExceptionEnums() {
        return exceptionEnums;
    }
}
