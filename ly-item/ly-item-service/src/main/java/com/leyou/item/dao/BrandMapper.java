package com.leyou.item.dao;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xubing
 * @date 2019/3/27
 */
@Mapper
public interface BrandMapper {
    List<Brand> queryAllBrand();

    //传入搜索条件search，排序descending，排序字段sortBy
    List<Brand> queryAllByParams(@Param("search") String search, @Param("descending") boolean descending,@Param("sortBy") String sortBy);
}
