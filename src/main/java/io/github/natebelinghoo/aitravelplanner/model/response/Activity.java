package io.github.natebelinghoo.aitravelplanner.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 活动安排
 * 
 * @author xyt
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    
    /**
     * 时间
     * 如: 09:00-11:00
     */
    private String time;
    
    /**
     * 标题
     * 如: 漫步西湖苏堤
     */
    private String title;
    
    /**
     * 描述
     */
    private String description;
    
    /**
     * 位置
     * 如: 西湖苏堤
     */
    private String location;
    
    /**
     * 类别
     * 如: 景点、美食、交通、休息
     */
    private String category;
    
    /**
     * 预计时长
     * 如: 2小时
     */
    private String duration;
    
    /**
     * 费用预估
     * 如: 免费、50元
     */
    private String cost;
    
    /**
     * 交通方式
     * 如: 步行、地铁、打车
     */
    private String transportation;
    
    /**
     * 备注
     */
    private String notes;
}
