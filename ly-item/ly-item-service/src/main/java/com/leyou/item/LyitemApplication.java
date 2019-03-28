package com.leyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xubing
 * @date 2019/3/18
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.leyou.item.dao")
public class LyitemApplication {
    public static void main(String[] args) {
        new SpringApplication().run(LyitemApplication.class);
    }
}
