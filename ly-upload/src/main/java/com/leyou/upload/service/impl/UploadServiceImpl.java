package com.leyou.upload.service.impl;

import com.leyou.common.exception.BaseException;
import com.leyou.common.exception.LyException;
import com.leyou.upload.service.UploadService;
import com.leyou.upload.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xubing
 * @date 2019/4/1
 */
@Slf4j
@Service
public class UploadServiceImpl implements UploadService {

    @Override
    public Object uploadImge(MultipartFile inputfile, HttpServletRequest request) throws BaseException {
        if(null == inputfile){
            throw new BaseException("文件不能为空");
        }
        Map<String, Object> map = new HashMap<>();
        try {
            map = FileUtils.fileUpload(inputfile, "F:/upload", "/leyou/image", request, "images", 1);
            log.info("[文件上传] => {}",inputfile.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            throw new BaseException(HttpStatus.BAD_REQUEST,e.getLocalizedMessage());
        }
        return map;
    }
}
