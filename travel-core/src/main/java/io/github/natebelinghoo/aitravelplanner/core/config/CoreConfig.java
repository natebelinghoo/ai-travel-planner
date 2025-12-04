package io.github.natebelinghoo.aitravelplanner.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Core 模块配置
 * 
 * @author xyt
 */
@Configuration
public class CoreConfig {
    
    /**
     * 配置 ObjectMapper Bean
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}

