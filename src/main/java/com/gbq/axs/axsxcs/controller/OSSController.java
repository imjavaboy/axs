package com.gbq.axs.axsxcs.controller;

import com.gbq.axs.axsxcs.pojo.ResBean;
import com.gbq.axs.axsxcs.service.OSSService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName OSSController
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/24 23:00
 */
@Api(tags = "上传图片")
@RestController
@RequestMapping("/cat")
@CrossOrigin
public class OSSController {
    @Autowired
    private OSSService ossService;

    @PostMapping("/oss/upload")
    public ResBean upload(@RequestPart("file") MultipartFile file){
        String url = ossService.uploadFile(file);
        return ResBean.success("返回url成功",url) ;
    }
}
