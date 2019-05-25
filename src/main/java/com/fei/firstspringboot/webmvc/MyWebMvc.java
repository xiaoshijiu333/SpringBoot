package com.fei.firstspringboot.webmvc;

import com.fei.firstspringboot.filter.MyFilter;
import com.fei.firstspringboot.interception.MyInterception;
import com.fei.firstspringboot.servlet.Myservlet;
import com.fei.firstspringboot.webmvc.localeResolver.MyLocaleResolver;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author xiaoshijiu
 * @Description 自定义Mvc配置，实现全面接管SpringMvc的配置
 * @Date 2019/5/13
 */
@Configuration
public class MyWebMvc implements WebMvcConfigurer {

    /**
     * 自定义静态资源映射处理 /** 将所有静态资源请求全部映射到 classpath:/static/ 目录下
     * 取代了之前的静态文件映射路径（原来是支持四个路径）
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 添加视图映射 将某个请求转发到某个视图 视图映射需要在引入模板引擎thymeleaf情况下，会自动拼接前缀/templates，后缀.html
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/login");
        // 设置了欢迎页的作用
        registry.addViewController("/").setViewName("/login");
    }

    /**
     * 注册自定义的LocaleResolver
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    /**
     * 注册自定义的servlet 就相当于在普通web工程中，在web.xml中注册的<servlet></servlet>
     */
    @Bean
    public ServletRegistrationBean myServlet() {
        return new ServletRegistrationBean(new Myservlet(), "/myservlet");
    }

    /**
     * 注册自定义的filter 就相当于在普通web工程中，在web.xml中注册的<filter></filter>
     */
    @Bean
    public FilterRegistrationBean myFilter() {
        return new FilterRegistrationBean(new MyFilter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加自定义的拦截器
        registry.addInterceptor(new MyInterception()).addPathPatterns("/hello");
    }
}
