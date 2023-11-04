package com.zac.job;

import com.zac.feign.annotation.EnableHtxFeignClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableHtxFeignClients(basePackages = "com.zac.request.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class JobApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
        log.info("""
                
                ----------------------------------------------------------
                    JobApplication is running!
                ----------------------------------------------------------\s""");
    }
}