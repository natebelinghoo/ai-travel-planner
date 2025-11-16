package io.github.xyt662.aitravelplanner.agent;

import io.github.xyt662.aitravelplanner.model.AgentOutput;
import io.github.xyt662.aitravelplanner.service.AmapService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 交通规划 Agent
 * 负责解决"如何去"的问题，专注于跨城市、长途的交通规划
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TransportationPlannerAgent implements Agent {
    
    private final AmapService amapService;
    
    @Override
    public AgentOutput execute(Map<String, Object> input) {
        try {
            // 1. 解析输入参数
            String origin = (String) input.get("origin");
            String destination = (String) input.get("destination");
        
            // 2. 地理编码 - 获取起点坐标
            String originCoords = amapService.amapGeocoding(origin);
        
            // 3. 地理编码 - 获取终点坐标  
            String destinationCoords = amapService.amapGeocoding(destination);
        
            // 4. 路径规划 - 基于坐标进行路径规划
            String routeResult = amapService.amapRoutePlanning(originCoords, destinationCoords);
        
            // 5. 构建返回数据
            Map<String, Object> data = Map.of(
                "originCoords", originCoords,
                "destinationCoords", destinationCoords,
                "routeResult", routeResult,
                "origin", origin,
                "destination", destination
            );
            
            return AgentOutput.success(data, "交通规划完成");
            
        } catch (Exception e) {
            return AgentOutput.failure("交通规划失败: " + e.getMessage());
        }
    }
    
    @Override
    public String getName() {
        return "交通规划师";
    }
    
    @Override
    public String getDescription() {
        return "专注于解决'如何去'的问题，负责所有跨城市、长途的交通规划";
    }
    
    @Override
    public long getTimeout() {
        return 15000; // 交通规划 15 秒超时
    }
}
