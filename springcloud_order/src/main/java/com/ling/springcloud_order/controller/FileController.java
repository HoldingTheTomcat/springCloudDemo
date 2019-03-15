package com.ling.springcloud_order.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TianHeLing
 * @Description
 * @date 2019/3/15
 */
@RestController
@RequestMapping("uploadFile")
public class FileController {
    
    @PostMapping(value = "/server",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String,Object> fileUploadServer(MultipartFile file){
        Map<String, Object> map = new HashMap<>();
        map.put("name", file.getOriginalFilename());
        return map;
    }
}
