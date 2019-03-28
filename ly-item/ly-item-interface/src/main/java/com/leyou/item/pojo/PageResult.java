package com.leyou.item.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author xubing
 * @date 2019/3/28
 * 分页返回的实体类
 */
@Data
@ToString
public class PageResult<T> {
    private int pageSize;//总页数

    private int total;//总数

    private List<T> datalist;

    public PageResult(int pageSize, List<T> datalist) {
        this.pageSize = pageSize;
        this.datalist = datalist;
    }

    public PageResult(int pageSize, int total, List<T> datalist) {
        this.pageSize = pageSize;
        this.total = total;
        this.datalist = datalist;
    }
}
