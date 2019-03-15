package com.ling.springcloud_user.dao;

/**
 * @author TianHeLing
 * @Description
 * @date 2019/3/15
 */

import com.ling.springcloud_user.config.FeignMultipartSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@FeignClient(value = "spring-cloud-order",configuration = FeignMultipartSupportConfig.class)
public interface FeignUploadClient {

    @PostMapping(value = "/uploadFile/server",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Map<String, Object> fileUploadServer(@RequestPart(value = "file") MultipartFile file);
}
