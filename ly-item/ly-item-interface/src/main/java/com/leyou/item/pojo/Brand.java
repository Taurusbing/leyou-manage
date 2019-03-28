package com.leyou.item.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author xubing
 * @date 2019/3/27
 */
@Data
@ToString
public class Brand {
    private Long id;

    private String name;

    private String image;

    private String letter;
}
