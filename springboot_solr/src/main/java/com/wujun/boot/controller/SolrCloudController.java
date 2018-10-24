package com.wujun.boot.controller;

import com.wujun.common.responses.ApiResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Auther: Jun.Wu
 * @Date: 2018-10-24 13:53
 * @Description:
 */
@RestController
@RequestMapping("solrcould")
public class SolrCloudController {

    @Autowired
    private CloudSolrClient client;

    @RequestMapping(value = "search",method = RequestMethod.POST)
    public ApiResult search(){
        try {
            client.setDefaultCollection("demo_collection");
            SolrQuery params = new SolrQuery();
            params.set("q","test_address:杭州");
            params.addSort("test_age",SolrQuery.ORDER.desc);
            params.set("df","test_name");
            //params.set("fl","test_name,test_age,test_address");
            QueryResponse response = client.query(params);
            SolrDocumentList results = response.getResults();
            ApiResult result = ApiResult.SUCCESS();
            result.setData(results);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ApiResult.FAIL();
    }


    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ApiResult<String> add(@RequestParam("name") String name, @RequestParam("value") String value){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        try {
            SolrInputDocument doc = new SolrInputDocument();
            doc.setField("id",uuid);
            doc.setField(name,value);
            UpdateResponse response = client.add(doc);
            client.commit();
            ApiResult result = ApiResult.SUCCESS();
            result.setData(uuid);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResult.FAIL();
    }
}
