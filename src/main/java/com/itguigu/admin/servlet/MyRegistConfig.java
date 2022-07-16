//package com.itguigu.admin.servlet;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
////(proxyBeanMethods = true): 保证依赖的组件始终是单实例的
//@Configuration(proxyBeanMethods = true)
//public class MyRegistConfig {
//    @Bean
//    public ServletRegistrationBean myservlet(){
//        MyServlet myServlet = new MyServlet();
//        return new ServletRegistrationBean(myServlet,"/my","/my02");
//    }
//
//    @Bean
//    public FilterRegistrationBean myFilter(){
//        MyFilter myFilter = new MyFilter();
////      在此拦截上面servlet中已加入的拦截路径
////        return new FilterRegistrationBean(myFilter,myservlet());
//
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
//        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","my02"));
//        return filterRegistrationBean;
//    }
//
//    @Bean
//    public ServletListenerRegistrationBean myListener(){
//        MyServletContextListener myServletContextListener = new MyServletContextListener();
//        return new ServletListenerRegistrationBean(myServletContextListener);
//    }
//}
