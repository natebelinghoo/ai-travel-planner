package io.github.xyt662.aitravelplanner.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 日度行程
 * 
 * @author xyt
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DayItinerary {
    
    /**
     * 第几天
     */
    private Integer day;
    
    /**
     * 日期
     * 格式: yyyy-MM-dd
     */
    private String date;
    
    /**
     * 活动列表
     */
    private List<Activity> activities;
    
    /**
     * 当日总结
     */
    private String summary;
    
    /**
     * 当日主题
     * 如: 西湖风光与古刹禅意
     */
    private String theme;
    
    /**
     * 当日总费用预估
     */
    private String totalCost;
    
    /**
     * 当日总步行距离
     */
    private String totalDistance;
    
    /**
     * 当日亮点
     */
    private List<String> highlights;
}
