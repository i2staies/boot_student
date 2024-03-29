package com.itguigu.admin.config;

import com.itguigu.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  1. 编写一个拦截器实现HandlerInterceptor接口
 *  2. 拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors方法）
 *  2. 指定拦截规则，如果是拦截所有，会拦截静态资源
 */
//EnableWebMvc: 全面接管
//    静态资源，自动装配，视图解析器什么的全部失效
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/js/**","/fonts/**","/images/**");
    }
}
