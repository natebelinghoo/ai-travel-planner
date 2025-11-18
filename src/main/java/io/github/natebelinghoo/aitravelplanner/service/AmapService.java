package io.github.natebelinghoo.aitravelplanner.service;

/**
 * 高德地图服务接口
 * 
 * @author xyt
 */
public interface AmapService {
    
    /**
     * 高德地图地理编码
     * 
     * @param position 查询地址
     * @return 地理编码结果
     */
    String amapGeocoding(String position);

    /**
     * 高德地图路径规划
     * 
     * @param origin 起点
     * @param destination 终点
     * @return 路径规划结果
     */
    String amapRoutePlanning(String origin, String destination);
}
