package com.leyou.upload.controller;

import com.leyou.common.vo.RestResponse;
import com.leyou.upload.service.UploadService;
import com.leyou.upload.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xubing
 * @date 2019/4/1
 */
@RestController
@RequestMapping("upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping("uploadImage")
    public Object uploadImage(@RequestParam MultipartFile inputfile, HttpServletRequest request){
        return uploadService.uploadImge(inputfile,request);
    }
}
