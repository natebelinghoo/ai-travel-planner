package io.github.xyt662.aitravelplanner.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.xyt662.aitravelplanner.config.AppProperties;
import io.github.xyt662.aitravelplanner.service.AmapService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 高德地图服务实现
 * 
 * @author xyt
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AmapServiceImpl implements AmapService {
    
    private final AppProperties appProperties;
    private final ObjectMapper objectMapper;
    private final OkHttpClient httpClient;
    
    @Override
    public String amapGeocoding(String position) {
        log.info("执行高德地图地理编码: position={}", position);
        
        try {
            // 构建请求URL
            String encodedPosition = URLEncoder.encode(position, StandardCharsets.UTF_8);
            String url = String.format("https://restapi.amap.com/v3/geocode/geo?key=%s&address=%s",
                    appProperties.getApiKeys().getAmap(), encodedPosition);
            
            // 构建HTTP请求
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            
            // 发送请求
            try (Response response = httpClient.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    throw new IOException("高德地图API调用失败: " + response.code());
                }
                
                String responseBody = response.body().string();
                log.info("高德地图地理编码API响应成功");
                
                // 解析响应，提取location信息
                return parseGeocodingResponse(responseBody);
            }
            
        } catch (Exception e) {
            log.error("高德地图地理编码失败", e);
            throw new RuntimeException("地理编码失败: " + e.getMessage(), e);
        }
    }
    
    @Override
    public String amapRoutePlanning(String origin, String destination) {
        log.info("执行高德地图路径规划: origin={}, destination={}", origin, destination);
        // TODO: 实现高德地图路径规划功能
        return "路径规划结果";
    }
    
    /**
     * 解析地理编码响应，提取location信息
     */
    private String parseGeocodingResponse(String responseBody) {
        try {
            JsonNode rootNode = objectMapper.readTree(responseBody);
            
            // 检查状态
            String status = rootNode.get("status").asText();
            if (!"1".equals(status)) {
                String info = rootNode.get("info").asText();
                throw new RuntimeException("高德地图API返回错误: " + info);
            }
            
            // 提取geocodes数组
            JsonNode geocodesNode = rootNode.get("geocodes");
            if (geocodesNode == null || !geocodesNode.isArray()) {
                return "[]";
            }
            
            List<String> locations = new ArrayList<>();
            
            for (JsonNode geocode : geocodesNode) {
                String location = geocode.get("location").asText();
                if (location != null && !location.isEmpty()) {
                    locations.add(location);
                }
            }
            
            // 返回JSON格式的location列表
            return objectMapper.writeValueAsString(locations);
            
        } catch (Exception e) {
            log.error("解析地理编码响应失败", e);
            throw new RuntimeException("解析响应失败: " + e.getMessage(), e);
        }
    }
}
