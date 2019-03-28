package com.leyou.item.service.Impl;

import com.leyou.item.dao.CategoryMapper;
import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xubing
 * @date 2019/3/26
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllCategory() {
        return categoryMapper.queryAllCategory();
    }

    @Override
    public List<Category> queryCategoryByParentId(Long pid) {
        return categoryMapper.queryCategoryByParentId(pid);
    }
}
