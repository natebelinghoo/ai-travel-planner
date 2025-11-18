package io.github.natebelinghoo.aitravelplanner.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 景点信息
 * 
 * @author xyt
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attraction {
    
    /**
     * 景点名称
     */
    private String name;
    
    /**
     * 描述
     */
    private String description;
    
    /**
     * 标签
     * 如: 自然风光、历史文化、美食体验
     */
    private List<String> tags;
    
    /**
     * 位置
     * 如: 杭州市西湖区
     */
    private String location;
    
    /**
     * 类别
     * 如: 景点、餐厅、购物、娱乐
     */
    private String category;
    
    /**
     * 推荐指数 (1-5星)
     */
    private Integer rating;
    
    /**
     * 预计游览时间
     * 如: 2-3小时
     */
    private String estimatedTime;
    
    /**
     * 门票价格
     * 如: 免费、30元、50-100元
     */
    private String ticketPrice;
    
    /**
     * 开放时间
     */
    private String openingHours;
    
    /**
     * 地址详情
     */
    private String address;
}
