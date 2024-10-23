package com.hmall.api.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author lihaopeng
 * @version 1.0
 * @project hmall
 * @description
 * @since 2024/10/23 11:00
 */
public class DefaultFeignConfig {
    @Bean
    public Logger.Level feignLogLevel(){
        // 平时开发可以不需要输出日志
        return Logger.Level.NONE;
        // 上线时可以开启FULL日志级别
        // return Logger.Level.FULL;
    }
}
