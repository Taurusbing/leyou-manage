package com.leyou.upload.service;

import com.leyou.common.exception.BaseException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xubing
 * @date 2019/4/1
 */
public interface UploadService {

    Object uploadImge(MultipartFile inputfile, HttpServletRequest request) throws BaseException;
}
