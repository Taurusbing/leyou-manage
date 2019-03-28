package com.leyou.item.controller;

import com.leyou.common.enums.ExceptionEnums;
import com.leyou.common.exception.LyException;
import com.leyou.item.pojo.Category;
import com.leyou.item.pojo.Item;
import com.leyou.item.service.CategoryService;
import com.leyou.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xubing
 * @date 2019/3/18
 */
@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

//    @PostMapping
//    public ResponseEntity<Item> saveItem(Item item){
//        if(item.getPrice() == null){
//            throw new LyException(ExceptionEnums.ITEM_PRICE_CANNOT_NULL);
//        }
//        Item item1 = itemService.saveItem(item);
//        return ResponseEntity.status(HttpStatus.CREATED).body(item);
//    }

    /*
    * 获取全量的category商品分类
    * */
    @GetMapping("category/all")
    public ResponseEntity<List<Category>> queryAllCate(){
        List<Category> categories = categoryService.queryAllCategory();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    /*
    * 根据父级id获取该父级下的所有分类
    * */
    @GetMapping("category/queryBypPid")
    public ResponseEntity<List<Category>> queryByParentId(@RequestParam(value = "pid" ,defaultValue = "0")Long pid){
        List<Category> categories = categoryService.queryCategoryByParentId(pid);
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
}
