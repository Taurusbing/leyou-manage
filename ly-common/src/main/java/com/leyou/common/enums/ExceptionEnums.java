package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author xubing
 * @date 2019/3/18
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum  ExceptionEnums {

    ITEM_PRICE_CANNOT_NULL(400,"价格不能为空")
    ;

    private int code;

    private String msg;

}
