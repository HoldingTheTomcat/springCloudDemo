package com.ling.springcloud_user.controller;

import com.ling.springcloud_user.dao.FeignUploadClient;
import com.ling.springcloud_user.entity.Order;
import com.ling.springcloud_user.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by LingZi on 2018/11/24.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private OrderService orderInterface;

    @Autowired
    private FeignUploadClient feignUploadClient;
    
    @RequestMapping("order")
    @ResponseBody
    public Order  getOrderInfo(){
        return orderInterface.getOrderInfo();
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String, Object> imageUpload(MultipartFile file) throws Exception {
        Map<String, Object> stringObjectMap = feignUploadClient.fileUploadServer(file);
        return stringObjectMap;
    }
    
}
