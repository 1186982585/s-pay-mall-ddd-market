package com.example.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author cxj
 * @Date 2025/11/20 20:06
 * @Description: http 框架
 */
@Configuration
public class OKHttpClientConfig {

    @Bean
    public OkHttpClient httpClient() {
        return new OkHttpClient();
    }

}
