package com.lqjk.autocode;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
@MapperScan(basePackages = {"com.lqjk.autocode.mapper","com.baomidou.mybatisplus.core.mapper"})
public class AutoCodeApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(AutoCodeApplication.class, args);

        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        log.info("""
                
                ----------------------------------------------------------
                AutoCodeApplication Start is running! Requests URLs:
                Swagger文档: http://""" + ip + ":" + port + """
                /doc.html#/home
                ----------------------------------------------------------""");
    }

}