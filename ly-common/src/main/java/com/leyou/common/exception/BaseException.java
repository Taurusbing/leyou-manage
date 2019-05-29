package com.leyou.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {
    private HttpStatus status;
    private String errorMessage;
    private Object data;

    public BaseException(String errorMessage) {
        super(errorMessage);
        this.status = HttpStatus.BAD_REQUEST;
        this.errorMessage = errorMessage;
        this.data = null;
    }

    public BaseException(HttpStatus status, String errorMessage) {
        super(errorMessage);
        this.status = status;
        this.errorMessage = errorMessage;
        this.data = null;
    }

    public BaseException(HttpStatus status, String errorMessage, Object data) {
        super(errorMessage);
        this.status = status;
        this.errorMessage = errorMessage;
        this.data = data;
    }
}