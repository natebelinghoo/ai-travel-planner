package io.github.xyt662.aitravelplanner.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 完整旅行行程
 * 
 * @author xyt
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelItinerary {
    
    /**
     * 行程标题
     * 如: 杭州3日游行程规划
     */
    private String title;
    
    /**
     * 出发地
     */
    private String origin;
    
    /**
     * 目的地
     */
    private String destination;
    
    /**
     * 出发日期
     */
    private String departureDate;
    
    /**
     * 旅行天数
     */
    private Integer days;
    
    /**
     * 交通方案
     */
    private List<TransportationOption> transportationOptions;
    
    /**
     * 日度行程列表
     */
    private List<DayItinerary> dayItineraries;
    
    /**
     * 行程总结
     */
    private String summary;
    
    /**
     * 总费用预估
     */
    private String totalCost;
    
    /**
     * 行程亮点
     */
    private List<String> highlights;
    
    /**
     * 注意事项
     */
    private List<String> notes;
    
    /**
     * 推荐指数
     */
    private Integer rating;
    
    /**
     * 创建时间
     */
    private String createdAt;
}
