package com.neusoft.demosb.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //拦截索引url，但是忽略“/login”和“/”
                .addPathPatterns("/**")
                .excludePathPatterns("/admin/toLogin").excludePathPatterns("/admin/login");
    }
}
