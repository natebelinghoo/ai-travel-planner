package io.github.natebelinghoo.aitravelplanner.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Tavily 搜索响应
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TavilySearchResponse {
    
    /**
     * 搜索结果列表
     */
    private List<SearchResult> results;
    
    /**
     * 搜索查询
     */
    private String query;
    
    /**
     * 搜索耗时
     */
    private Double searchTime;
    
    /**
     * 搜索结果数量
     */
    private Integer resultCount;
    
    /**
     * 搜索结果
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchResult {
        
        /**
         * 标题
         */
        private String title;
        
        /**
         * 内容
         */
        private String content;
        
        /**
         * URL
         */
        private String url;
        
        /**
         * 评分
         */
        private Double score;
        
        /**
         * 发布时间
         */
        private String publishedDate;
        
        /**
         * 来源
         */
        private String source;
    }
}
