package com.leyou.item.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.item.dao.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.PageResult;
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
        return brandMapper.queryAllBrand();
    }

    @Override
    public PageResult<Brand> queryAllByParams(int page, int rows, String search, boolean descending, String sortBy) {
        //开始分页
//        PageHelper.startPage(page, rows);
//        Page<Brand> pageInfo = (Page<Brand>) brandMapper.queryAllByParams(search, descending, sortBy);

        //匿名内部类方式
//        Page<Brand> pageInfo1 = PageHelper.startPage(page, rows)
//                .doSelectPage(new ISelect() {
//                    @Override
//                    public void doSelect() {
//                        brandMapper.queryAllByParams(search, descending, sortBy);
//                    }
//                });

        //使用函数式编程方式
        Page<Brand> pageInfo = PageHelper.startPage(page, rows)
                .doSelectPage(() -> brandMapper.queryAllByParams(search, descending, sortBy));

        return new PageResult<Brand>(pageInfo.getTotal(),pageInfo);

    }
}
