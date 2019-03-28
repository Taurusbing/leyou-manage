package com.leyou.item.dao;

import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xubing
 * @date 2019/3/26
 */
@Mapper
public interface CategoryMapper {

    List<Category> queryAllCategory();

    List<Category> queryCategoryByParentId(Long pid);
}
