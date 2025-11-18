package io.github.natebelinghoo.aitravelplanner.agent;

import io.github.natebelinghoo.aitravelplanner.model.AgentOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 行程生成 Agent
 * 负责"规划与编排"，接收前两个 Agent 的输出，生成完整的日度行程计划
 * 
 * @author xyt
 */
@Slf4j
@Component
public class ItineraryGeneratorAgent implements Agent {
    
    @Override
    public AgentOutput execute(Map<String, Object> input) {
        log.info("开始执行行程生成任务，输入参数: {}", input);
        
        try {
            // TODO: 实现具体的行程生成逻辑
            // 1. 解析交通方案和景点列表
            // 2. 调用通义千问 API 生成行程
            // 3. 处理返回结果
            // 4. 返回完整的行程计划
            
            // 临时返回示例数据
            Map<String, Object> data = Map.of(
                "itinerary", "完整行程计划",
                "days", input.get("days"),
                "summary", "行程总结"
            );
            
            return AgentOutput.success(data, "行程生成完成");
            
        } catch (Exception e) {
            log.error("行程生成执行失败", e);
            return AgentOutput.failure("行程生成失败: " + e.getMessage());
        }
    }
    
    @Override
    public String getName() {
        return "行程设计师";
    }
    
    @Override
    public String getDescription() {
        return "负责'规划与编排'，接收前两个 Agent 的输出，生成完整的日度行程计划";
    }
    
    @Override
    public long getTimeout() {
        return 30000; // 行程生成 30 秒超时
    }
}