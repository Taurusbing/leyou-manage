package com.leyou.item.service;

import com.leyou.item.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xubing
 * @date 2019/3/26
 */
@Service
public interface CategoryService {

    List<Category> queryAllCategory();

    List<Category> queryCategoryByParentId(Long pid);
}
