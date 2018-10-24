package com.wujun.boot.config;

import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Jun.Wu
 * @Date: 2018-10-24 14:10
 * @Description:
 */
@Configuration
public class SolrConfig {
    @Value("${spring.data.solr.zk-host}")
    private String zkHost;

    @Bean
    public CloudSolrClient solrClient(){
        CloudSolrClient client = new CloudSolrClient(zkHost);
        client.setDefaultCollection("demo_collection");
        return client;
    }
}
