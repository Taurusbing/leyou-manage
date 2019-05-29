package com.leyou.common.active;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leyou.common.exception.BaseException;
import com.leyou.common.vo.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;


/**
 * Global Exception Handle
 *
 * @author xieguo
 */
@ControllerAdvice
class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private ObjectMapper objectMapper;

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<?> handleBaseException(BaseException base) {
        log.error("BaseException:{}", base);
        if (base.getData() != null) {
            return ResponseEntity
                    .status(base.getStatus())
                    .body(RestResponse.error(base.getData()));
        }
        return ResponseEntity.status(base.getStatus()).body(RestResponse.error(base.getErrorMessage()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException e) {
        log.error("AccessDeniedException:{}", e.getMessage());
        return ResponseEntity.status(FORBIDDEN).body(RestResponse.error(FORBIDDEN.getReasonPhrase()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("HttpMessageNotReadableException:{}", e.getMessage());
        return ResponseEntity.status(BAD_REQUEST).body(RestResponse.error(e.getMessage()));
    }

    @ExceptionHandler(value = {NullPointerException.class, ArrayIndexOutOfBoundsException.class})
    public ResponseEntity<?> handleCommonException(Exception ex) {
        log.error("Common Exception:{}", ex);
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(RestResponse.error(INTERNAL_SERVER_ERROR.getReasonPhrase()));
    }

    @ExceptionHandler(value = {HttpServerErrorException.class})
    public ResponseEntity<?> handleHttpServerErrorException(HttpServerErrorException ex) {
        log.error("HttpServerErrorException:{}", ex);
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(RestResponse.error(INTERNAL_SERVER_ERROR.getReasonPhrase()));
    }

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseEntity<?> handleHttpClientErrorException(HttpClientErrorException ex) {
        log.error("HttpClientErrorException:{}", ex);
        return ResponseEntity.status(BAD_REQUEST).body(RestResponse.error(ex.getStatusText()));
    }

    @ExceptionHandler(value = {RestClientException.class})
    public ResponseEntity<?> handleRestClientException(RestClientException ex) {
        log.error("RestClientException:{}", ex);
        return ResponseEntity.status(BAD_REQUEST).body(RestResponse.error(ex.getMessage()));
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public final ResponseEntity<?> handleConstraintViolationException(MethodArgumentNotValidException ex, WebRequest request) throws JsonProcessingException {
        log.error("ConstraintViolationException:{}", ex);
        return getExceptionResponseEntity(ex);
    }

    @ExceptionHandler(value = {BindException.class})
    public final ResponseEntity<?> handleBindException(BindException ex) throws JsonProcessingException {
        log.error("BindException:{}", ex);
        return getExceptionResponseEntity(ex);
    }

    private ResponseEntity<?> getExceptionResponseEntity(Exception ex) throws JsonProcessingException
    {
        BindingResult bindingResult = null;
        if( ex instanceof BindException) {
            bindingResult = ((BindException) ex).getBindingResult();
        }
        if( ex instanceof MethodArgumentNotValidException) {
            bindingResult = ((MethodArgumentNotValidException) ex).getBindingResult();
        }
        if( null != bindingResult ) {
            Map<String, String> errorMessages = new HashMap<>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                if (error instanceof FieldError) {
                    errorMessages.put(((FieldError) error).getField(), error.getDefaultMessage());
                } else {
                    errorMessages.put(error.getObjectName(), error.getDefaultMessage());
                }
            }
            return ResponseEntity.status(BAD_REQUEST).body(RestResponse.error(objectMapper.writeValueAsString(errorMessages), errorMessages));
        }
        return ResponseEntity.status(BAD_REQUEST).body(RestResponse.error());
    }
}