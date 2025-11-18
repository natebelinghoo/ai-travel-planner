package io.github.natebelinghoo.aitravelplanner.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * 交通规划请求
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransportationRequest {
    
    /**
     * 出发地
     */
    @NotBlank(message = "出发地不能为空")
    private String origin;
    
    /**
     * 目的地
     */
    @NotBlank(message = "目的地不能为空")
    private String destination;
    
    /**
     * 交通偏好
     * 可选值: 高铁优先、飞机优先、自驾优先、经济实惠
     */
    private String travelPreference;
    
    /**
     * 出发日期
     * 格式: yyyy-MM-dd
     */
    @NotBlank(message = "出发日期不能为空")
    private String departureDate;
    
    /**
     * 出发时间（可选）
     * 格式: HH:mm
     */
    private String departureTime;
}
