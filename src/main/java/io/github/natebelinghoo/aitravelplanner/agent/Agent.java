package io.github.natebelinghoo.aitravelplanner.agent;

import io.github.natebelinghoo.aitravelplanner.model.AgentOutput;
import java.util.Map;

/**
 * Agent 接口
 * 定义所有 Agent 的统一行为
 */
public interface Agent {
    
    /**
     * 执行 Agent 任务
     * 
     * @param input 输入参数
     * @return Agent 执行结果
     */
    AgentOutput execute(Map<String, Object> input);
    
    /**
     * 获取 Agent 名称
     * 
     * @return Agent 名称
     */
    String getName();
    
    /**
     * 获取 Agent 描述
     * 
     * @return Agent 描述
     */
    String getDescription();
    
    /**
     * 检查 Agent 是否可用
     * 
     * @return true 如果可用，false 否则
     */
    default boolean isAvailable() {
        return true;
    }
    
    /**
     * 获取 Agent 执行超时时间（毫秒）
     * 
     * @return 超时时间，默认 30 秒
     */
    default long getTimeout() {
        return 30000;
    }
}