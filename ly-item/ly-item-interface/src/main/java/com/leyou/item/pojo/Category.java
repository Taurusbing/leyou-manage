package com.leyou.item.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author xubing
 * @date 2019/3/26
 */
@Data
@ToString
public class Category {
    private Long id;

    private String name;

    private Long parentId;

    private Integer isParent;

    private Integer sort;

    private List<Category> categories;
}
