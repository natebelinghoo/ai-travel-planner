package io.github.xyt662.aitravelplanner.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 应用配置属性类
 * 用于读取 application.yml 中的自定义配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    
    /**
     * API 密钥配置
     */
    private ApiKeys apiKeys = new ApiKeys();
    
    /**
     * 外部服务配置
     */
    private ExternalServices externalServices = new ExternalServices();
    
    /**
     * 旅行规划配置
     */
    private Travel travel = new Travel();
    
    @Data
    public static class ApiKeys {
        private String amap;
        private String tavily;
    }
    
    @Data
    public static class ExternalServices {
        private Amap amap = new Amap();
        private Tavily tavily = new Tavily();
        
        @Data
        public static class Amap {
            private String baseUrl = "https://restapi.amap.com/v3";
            private int timeout = 5000;
            private int retryCount = 3;
        }
        
        @Data
        public static class Tavily {
            private String baseUrl = "https://api.tavily.com";
            private int timeout = 10000;
            private int retryCount = 2;
            private int maxResults = 5;
        }
    }
    
    @Data
    public static class Travel {
        private int defaultDays = 3;
        private int maxDays = 14;
        private int maxAttractions = 10;
        private int maxRestaurants = 5;
    }
}
