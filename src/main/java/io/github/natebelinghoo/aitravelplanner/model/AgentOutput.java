package io.github.natebelinghoo.aitravelplanner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Agent 输出结果
 * 统一所有 Agent 的返回格式
 * 
 * @author xyt
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentOutput {
    
    /**
     * Agent 执行状态
     */
    private AgentStatus status;
    
    /**
     * 结构化数据
     * 包含 Agent 处理后的结构化信息
     */
    private Map<String, Object> data;
    
    /**
     * 消息内容
     * 用于显示给用户的消息或错误信息
     */
    private String message;
    
    /**
     * 执行时间（毫秒）
     */
    private Long executionTime;
    
    /**
     * 错误信息（如果执行失败）
     */
    private String errorMessage;
    
    /**
     * 创建成功结果
     */
    public static AgentOutput success(Map<String, Object> data, String message) {
        return AgentOutput.builder()
                .status(AgentStatus.SUCCESS)
                .data(data)
                .message(message)
                .build();
    }
    
    /**
     * 创建失败结果
     */
    public static AgentOutput failure(String errorMessage) {
        return AgentOutput.builder()
                .status(AgentStatus.FAILURE)
                .errorMessage(errorMessage)
                .message("执行失败: " + errorMessage)
                .build();
    }
    
    /**
     * 创建处理中结果
     */
    public static AgentOutput processing(String message) {
        return AgentOutput.builder()
                .status(AgentStatus.PROCESSING)
                .message(message)
                .build();
    }
}
