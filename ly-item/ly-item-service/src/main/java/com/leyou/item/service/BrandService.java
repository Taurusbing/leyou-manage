package com.leyou.item.service;

import com.leyou.item.pojo.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xubing
 * @date 2019/3/27
 */
public interface BrandService {
    List<Brand> queryAllBrand();
}
