package io.github.natebelinghoo.aitravelplanner.service;

/**
 * Tavily 搜索服务接口
 * 用于搜索本地景点、美食、活动等信息
 * 
 * @author xyt
 */
public interface TavilyService {
    
    /**
     * 通用搜索方法
     * 
     * @param query 搜索查询文本
     * @param maxResults 最大结果数
     * @return 搜索结果 JSON 字符串
     */
    String tavilySearch(String query, int maxResults);
}

