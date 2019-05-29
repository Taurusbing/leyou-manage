package com.leyou.common.active;/*
package com.leyou.common.active;

import com.leyou.common.enums.ExceptionEnums;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.ExceptionResult;
import com.leyou.item.pojo.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


*/
/**
 * @author xubing
 * @date 2019/3/18
 *//*

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResult> handlerException(LyException e){
        return ResponseEntity.status(e.getExceptionEnums().getCode()).body(new ExceptionResult(e.getExceptionEnums()));
    }

}
*/
