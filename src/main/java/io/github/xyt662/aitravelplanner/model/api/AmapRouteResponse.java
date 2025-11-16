package io.github.xyt662.aitravelplanner.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 高德地图路径规划响应
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AmapRouteResponse {
    
    /**
     * 状态码
     */
    private String status;
    
    /**
     * 信息
     */
    private String info;
    
    /**
     * 路径列表
     */
    private List<Route> routes;
    
    /**
     * 路径信息
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Route {
        
        /**
         * 路径距离（米）
         */
        private Integer distance;
        
        /**
         * 路径耗时（秒）
         */
        private Integer duration;
        
        /**
         * 路径策略
         */
        private String strategy;
        
        /**
         * 路径步骤
         */
        private List<Step> steps;
    }
    
    /**
     * 路径步骤
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Step {
        
        /**
         * 步骤距离（米）
         */
        private Integer distance;
        
        /**
         * 步骤耗时（秒）
         */
        private Integer duration;
        
        /**
         * 步骤描述
         */
        private String instruction;
        
        /**
         * 步骤类型
         */
        private String action;
    }
}
