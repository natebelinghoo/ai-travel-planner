package io.github.natebelinghoo.aitravelplanner.config;

import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * 全局工具配置
 * 
 * @author xyt
 */
@Configuration
@RequiredArgsConstructor
public class AgentToolsConfig {
    
    private final AppProperties appProperties;
    
    /**
     * 配置全局 OkHttpClient Bean，供外部服务调用复用
     */
    @Bean
    public OkHttpClient okHttpClient() {
        var externalServices = appProperties.getExternalServices();
        int connectTimeoutMs = Math.max(
            externalServices.getAmap().getTimeout(),
            externalServices.getTavily().getTimeout()
        );
        
        Duration timeout = Duration.ofMillis(connectTimeoutMs);
        
        return new OkHttpClient.Builder()
            .connectTimeout(timeout)
            .readTimeout(timeout)
            .writeTimeout(timeout)
            .build();
    }
}
