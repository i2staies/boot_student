package com.itguigu.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@ServletComponentScan(basePackages = "com.itguigu")
//扫描包下的servlet注解,指定原生servlet组件放在哪里
//但是没有登录就能访问，没有被拦截
//在这加上MapperScan就不用在比包下写@Mapper注解
@MapperScan("com.itguigu.admin.mapper")
@SpringBootApplication
public class BootStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootStudentApplication.class, args);
    }

}
