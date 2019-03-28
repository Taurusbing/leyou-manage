package com.leyou.item.dao;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xubing
 * @date 2019/3/27
 */
@Mapper
public interface BrandMapper {
    List<Brand> queryAllBrand();
}
