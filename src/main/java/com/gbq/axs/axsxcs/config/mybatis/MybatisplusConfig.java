package com.gbq.axs.axsxcs.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisplusConfig
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/14 12:27
 */
@Configuration
public class MybatisplusConfig {

    /*分页*/
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
