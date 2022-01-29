package com.gbq.axs.axsxcs.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName OssUtil
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/24 22:22
 */


@Component
public class OssUtil implements InitializingBean {
    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.keyid}")
    private String accessKeyID;
    @Value("${aliyun.oss.file.keysecret}")
    private String accesskeySecret;
    @Value("${aliyun.oss.file.bucketname}")
    private String bucketName;
    @Value("${aliyun.oss.file.urll}")
    private String url;

    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;
    public static String URL;
    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_ID = accessKeyID;
        ACCESS_KEY_SECRET = accesskeySecret;
        BUCKET_NAME = bucketName;
        URL = url;
    }
}

