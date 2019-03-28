package com.leyou.item.controller;

import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xubing
 * @date 2019/3/27
 */
@RestController
@RequestMapping("item")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("brand/queryAll")
    public ResponseEntity<List<Brand>> queryAll(){
        List<Brand> brands = brandService.queryAllBrand();
        return ResponseEntity.status(HttpStatus.OK).body(brands);
    }

    //按条件查询
//    @GetMapping("brand/queryAllByParams")
//    public
}
