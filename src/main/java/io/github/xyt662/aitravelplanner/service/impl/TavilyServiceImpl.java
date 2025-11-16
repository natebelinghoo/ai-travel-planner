package io.github.xyt662.aitravelplanner.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.xyt662.aitravelplanner.config.AppProperties;
import io.github.xyt662.aitravelplanner.service.TavilyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Tavily 搜索服务实现
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TavilyServiceImpl implements TavilyService {
    
    private final AppProperties appProperties;
    private final ObjectMapper objectMapper;
    private final OkHttpClient httpClient;
    
    @Override
    public String tavilySearch(String query, int maxResults) {
        log.info("执行 Tavily 搜索: query={}, maxResults={}", query, maxResults);
        
        try {
            // 构建请求体
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("query", query);
            requestBody.put("search_depth", "basic");
            requestBody.put("include_answer", false);
            requestBody.put("include_images", false);
            requestBody.put("include_raw_content", false);
            requestBody.put("max_results", maxResults);
            
            // 构建 HTTP 请求
            RequestBody body = RequestBody.create(
                objectMapper.writeValueAsString(requestBody),
                MediaType.get("application/json; charset=utf-8")
            );
            
            Request request = new Request.Builder()
                .url("https://api.tavily.com/search")
                .post(body)
                .addHeader("Authorization", "Bearer " + appProperties.getApiKeys().getTavily())
                .addHeader("Content-Type", "application/json")
                .build();
            
            // 发送请求
            try (Response response = httpClient.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    throw new IOException("Tavily API 调用失败: " + response.code());
                }
                
                String responseBody = response.body().string();
                log.info("Tavily API 响应成功");
                return responseBody;
            }
            
        } catch (Exception e) {
            log.error("Tavily API 调用失败", e);
            throw new RuntimeException("搜索失败: " + e.getMessage(), e);
        }
    }
}
