package com.leyou.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xubing
 * @date 2019/4/1
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LyuploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyuploadApplication.class);
    }
}
