package io.github.natebelinghoo.aitravelplanner.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import java.util.List;

/**
 * 完整的旅行规划请求
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelPlanningRequest {
    
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
     * 出发日期
     * 格式: yyyy-MM-dd
     */
    @NotBlank(message = "出发日期不能为空")
    private String departureDate;
    
    /**
     * 旅行天数
     */
    @NotNull(message = "旅行天数不能为空")
    @Min(value = 1, message = "旅行天数至少1天")
    @Max(value = 30, message = "旅行天数最多30天")
    private Integer days;
    
    /**
     * 兴趣标签
     */
    @NotNull(message = "兴趣标签不能为空")
    private List<String> interests;
    
    /**
     * 旅行风格
     */
    private String travelStyle;
    
    /**
     * 预算范围
     */
    private String budget;
    
    /**
     * 出发时间（可选）
     */
    private String departureTime;
    
    /**
     * 交通偏好
     */
    private String travelPreference;
}
