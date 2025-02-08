package com.mirror.xiaohongshu.search.config;

import jakarta.annotation.Resource;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.apache.http.HttpHost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: mirror
 * @Date: 2025/2/8 11:22
 * @Description:
 */
@Configuration
public class ElasticsearchRestHighLevelClient {

    @Resource
    private ElasticsearchProperties elasticsearchProperties;

    private static final String COLON = ":";
    private static final String HTTP = "http";

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        String address = elasticsearchProperties.getAddress();

        // 按冒号 ： 分隔
        String[] addressArr = address.split(COLON);
        // IP 地址
        String host = addressArr[0];
        // 端口
        int port = Integer.parseInt(addressArr[1]);

        HttpHost httpHost = new HttpHost(host, port, HTTP);

        return new RestHighLevelClient(RestClient.builder(httpHost));
    }
}