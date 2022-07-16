package com.itguigu.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@ServletComponentScan(basePackages = "com.itguigu")
//扫描包下的servlet注解,指定原生servlet组件放在哪里
//但是没有登录就能访问，没有被拦截
@SpringBootApplication
public class BootStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootStudentApplication.class, args);
    }

}
