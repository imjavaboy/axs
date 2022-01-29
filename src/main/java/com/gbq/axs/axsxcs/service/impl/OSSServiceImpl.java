package com.gbq.axs.axsxcs.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.internal.OSSUtils;
import com.gbq.axs.axsxcs.service.OSSService;
import com.gbq.axs.axsxcs.utils.OssUtil;


import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @ClassName OSSServiceImpl
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/24 23:04
 */
@Service
public class OSSServiceImpl implements OSSService {
    @Override
    public String uploadFile(MultipartFile file) {
        String url = null;
        String endpoint = OssUtil.END_POINT;
        String accessKeyId = OssUtil.ACCESS_KEY_ID;
        String accessKeySecret = OssUtil.ACCESS_KEY_SECRET;
        String bucketName = OssUtil.BUCKET_NAME;
        String prourl = OssUtil.URL;
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            InputStream inputStream = file.getInputStream();
            //获取上传的文件的名字
            String filename = file.getOriginalFilename();
            System.out.println(filename+"哈哈哈哈哈");
            //随机uuid是为了拼接文件名，防止用户上传两个名字相同的文件后覆盖掉前一个
            UUID uuid = UUID.randomUUID();
            //这里是为了按上传时间分配目录。精确到月
            //拼接成完整的文件名。
            filename = uuid + filename;
            //传入三个参数
            ossClient.putObject(bucketName, filename, inputStream);
            //拼接url
            url = "https://" + prourl + "/" + filename;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ossClient.shutdown();
        }
        return url;
    }
}

