package io.github.xyt662.aitravelplanner.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 交通方案
 * 
 * @author xyt
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransportationOption {
    
    /**
     * 交通方式
     * 如: 高铁、飞机、自驾、公交
     */
    private String mode;
    
    /**
     * 耗时
     * 如: 约4.5小时
     */
    private String duration;
    
    /**
     * 费用
     * 如: 约550元
     */
    private String cost;
    
    /**
     * 车次号/航班号
     * 如: G41、CA1234
     */
    private String transportNumber;
    
    /**
     * 描述
     * 如: 北京南站 -> 杭州东站
     */
    private String description;
    
    /**
     * 出发时间
     */
    private String departureTime;
    
    /**
     * 到达时间
     */
    private String arrivalTime;
    
    /**
     * 出发站点
     */
    private String departureStation;
    
    /**
     * 到达站点
     */
    private String arrivalStation;
    
    /**
     * 推荐指数 (1-5星)
     */
    private Integer recommendation;
}
