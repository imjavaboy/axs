package com.gbq.axs.axsxcs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.gbq.axs.axsxcs.mapper")
@EnableTransactionManagement
public class AxsxcsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AxsxcsApplication.class, args);
    }

}
