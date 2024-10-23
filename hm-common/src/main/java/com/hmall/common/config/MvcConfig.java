package com.hmall.common.config;

import com.hmall.common.interceptors.UserInfoInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lihaopeng
 * @version 1.0
 * @project hmall
 * @description
 * @since 2024/10/23 20:52
 */
@Configuration
// 网关中也引用了common，网关中就有了MvcConfig
// 而WebMvcConfigurer属于SpringMVC，网关没有SpringMVC，所以将SpringMVC中的东西放在网关中会报错。
// 我们希望只在为服务中生效，而在网关中不生效
// 利用SpringBoot自动装配，是可以带条件的
// 只需要在类上加上@ConditionalOnClass注解，指定DispatcherServlet类即可
// 也就是说，只有在类路径中存在DispatcherServlet类时，才会生效
// DispatcherServlet是SpringMVC中的核心类
// 微服务中有SpringMVC，网关中没有SpringMVC，所以在微服务中生效，网关中不生效
@ConditionalOnClass(DispatcherServlet.class)
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        registry.addInterceptor(new UserInfoInterceptor());
    }
}
