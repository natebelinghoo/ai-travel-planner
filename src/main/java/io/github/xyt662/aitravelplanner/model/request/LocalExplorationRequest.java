package io.github.xyt662.aitravelplanner.model.request;

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
 * 本地探索请求
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocalExplorationRequest {
    
    /**
     * 目的地
     */
    @NotBlank(message = "目的地不能为空")
    private String destination;
    
    /**
     * 兴趣标签
     * 可选值: 历史文化、自然风光、美食体验、购物娱乐、户外运动等
     */
    @NotNull(message = "兴趣标签不能为空")
    private List<String> interests;
    
    /**
     * 停留天数
     */
    @NotNull(message = "停留天数不能为空")
    @Min(value = 1, message = "停留天数至少1天")
    @Max(value = 30, message = "停留天数最多30天")
    private Integer days;
    
    /**
     * 旅行风格
     * 可选值: 休闲度假、深度体验、快速打卡、亲子游、情侣游
     */
    private String travelStyle;
    
    /**
     * 预算范围（可选）
     * 可选值: 经济实惠、中等消费、高端奢华
     */
    private String budget;
}
