package com.leyou.item.controller;

import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.PageResult;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /*
    * 按条件查询
    * search:搜索条件
    * descending排序方式，false升序，true降序
    * page:当前页码
    * rows：每页行数
    * sortBy：排序字段
    * totalItems：数据总数
    * */
    @GetMapping("brand/queryAllByParams")
    public ResponseEntity<PageResult<Brand>> queryAllByParams(
            @RequestParam(value = "search",required = false) String search,
            @RequestParam(value = "descending",defaultValue = "false") boolean descending,
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "rows",defaultValue = "8") int rows,
            @RequestParam(value = "sortBy",defaultValue = "id") String sortBy,
            @RequestParam(value = "totalItems",defaultValue = "0") String totalItems){

        //service传入搜索条件search，排序descending，排序字段sortBy
        //service中进行分页

        PageResult<Brand> pageResult = brandService.queryAllByParams(page,rows,search,descending,sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(pageResult);
    }
}
