package com.leyou.common.vo;

import lombok.Data;

/**
 * Default Base Rest Response
 *
 * @author xieguo
 */
@Data
public class RestResponse {

    private static final String SUCCESS = "0";
    private static final String FAILURE = "1";

    public static final String MSG_INTERNAL_ERROR = "服务器异常";
    public static final String MSG_QUERY_OK = "操作成功";


    private String result;
    private String message;
    private Object data;

    public RestResponse(String result, String message, Object data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public static RestResponse error(String message, Object data) {
        return new RestResponse(FAILURE, message, data);
    }

    public static RestResponse error( String message ) {
        return new RestResponse(FAILURE, message, null);
    }

    public static RestResponse error( Object data) {
        return new RestResponse(FAILURE, MSG_INTERNAL_ERROR, data);
    }

    public static RestResponse error() {
        return new RestResponse(FAILURE, MSG_INTERNAL_ERROR, null);
    }

    public static RestResponse ok() {
        return new RestResponse(SUCCESS, MSG_QUERY_OK, null);
    }

    public static RestResponse ok(String message) {
        return new RestResponse(SUCCESS, message, null);
    }

    public static RestResponse ok(Object data) {
        return new RestResponse(SUCCESS, MSG_QUERY_OK, data);
    }

    public static RestResponse ok(String message, Object data) { return new RestResponse(SUCCESS, message, data); }




}