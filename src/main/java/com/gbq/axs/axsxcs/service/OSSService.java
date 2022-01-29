package com.gbq.axs.axsxcs.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName OSSService
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/24 23:02
 */
public interface OSSService {
    String uploadFile(MultipartFile file);
}
