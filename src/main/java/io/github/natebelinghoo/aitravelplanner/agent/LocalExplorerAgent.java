package io.github.natebelinghoo.aitravelplanner.agent;

import io.github.natebelinghoo.aitravelplanner.model.AgentOutput;
import io.github.natebelinghoo.aitravelplanner.service.TavilyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 本地探索 Agent
 * 负责解决"玩什么"的问题，专注于探索目的地的景点、美食和活动
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class LocalExplorerAgent implements Agent {
    
    private final TavilyService tavilyService;
    
    @Override
    public AgentOutput execute(Map<String, Object> input) {
        log.info("开始执行本地探索任务，输入参数: {}", input);
        
        try {
            // 1. 解析输入参数
            String destination = (String) input.get("destination");
            @SuppressWarnings("unchecked")
            List<String> interests = (List<String>) input.get("interests");
            
            if (destination == null || destination.trim().isEmpty()) {
                return AgentOutput.failure("目的地不能为空");
            }
            
            // 2. 构建搜索查询
            StringBuilder query = new StringBuilder();
            query.append(destination).append("必游景点");
            
            if (interests != null && !interests.isEmpty()) {
                query.append(" ").append(String.join(" ", interests));
            }
            
            query.append(" 旅游攻略 美食推荐 活动推荐");
            
            // 3. 调用 Tavily Search API
            String searchResult = tavilyService.tavilySearch(query.toString(), 15);
            
            // 4. 构建返回数据
            Map<String, Object> data = Map.of(
                "searchResult", searchResult,
                "destination", destination,
                "interests", interests,
                "query", query.toString()
            );
            
            return AgentOutput.success(data, "本地探索完成");
            
        } catch (Exception e) {
            log.error("本地探索执行失败", e);
            return AgentOutput.failure("本地探索失败: " + e.getMessage());
        }
    }
    
    @Override
    public String getName() {
        return "本地探索家";
    }
    
    @Override
    public String getDescription() {
        return "专注于解决'玩什么'的问题，负责探索目的地的景点、美食和活动";
    }
    
    @Override
    public long getTimeout() {
        return 20000; // 本地探索 20 秒超时
    }
}