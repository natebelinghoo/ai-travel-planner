package io.github.natebelinghoo.aitravelplanner.model;

/**
 * Agent 执行状态枚举
 * 
 * @author xyt
 */
public enum AgentStatus {
    
    /**
     * 成功
     */
    SUCCESS,
    
    /**
     * 失败
     */
    FAILURE,
    
    /**
     * 处理中
     */
    PROCESSING,
    
    /**
     * 超时
     */
    TIMEOUT,
    
    /**
     * 部分成功
     */
    PARTIAL_SUCCESS
}
