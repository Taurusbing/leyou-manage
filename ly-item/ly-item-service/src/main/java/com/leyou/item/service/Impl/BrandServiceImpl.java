package com.leyou.item.service.Impl;

import com.leyou.item.dao.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xubing
 * @date 2019/3/27
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> queryAllBrand() {
        System.out.println("123");
        return brandMapper.queryAllBrand();
    }
}
