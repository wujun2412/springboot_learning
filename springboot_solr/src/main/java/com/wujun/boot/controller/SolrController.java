package com.wujun.boot.controller;

import com.wujun.common.responses.ApiResult;
import org.apache.naming.factory.ResourceLinkFactory;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

import static com.wujun.common.responses.ApiResult.SUCCESS;

/**
 * @Auther: Jun.Wu
 * @Date: 2018-10-23 10:54
 * @Description:
 */
@RestController
@RequestMapping("solr")
public class SolrController {

    @Autowired
    private SolrClient solrClient;


    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ApiResult<String> add(@RequestParam("name") String name, @RequestParam("value") String value){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        try {
            SolrInputDocument doc = new SolrInputDocument();
            doc.setField("id",uuid);
            doc.setField(name,value);
            UpdateResponse response = solrClient.add(doc);
            solrClient.commit();
            ApiResult result = ApiResult.SUCCESS();
            result.setData(uuid);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResult.FAIL();
    }

    @RequestMapping(value = "delete" ,method = RequestMethod.POST)
    public ApiResult delete(@RequestParam("id") String id){
        try {
            UpdateResponse response = solrClient.deleteById(id);
            solrClient.commit();
            ApiResult result = ApiResult.SUCCESS();
            result.setData(response.toString());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ApiResult.FAIL();
    }


    @RequestMapping(value = "getById", method = RequestMethod.POST)
    public ApiResult<String> getById(@RequestParam("name") String name){
        try {
            SolrDocument doc = solrClient.getById(name);
            System.out.println(doc);
            ApiResult result = ApiResult.SUCCESS();
            result.setData(doc.toString());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResult.FAIL();
    }

    @RequestMapping(value = "search",method = RequestMethod.POST)
    public ApiResult search(){
        try {
            SolrQuery params = new SolrQuery();
            params.set("q","test_address:杭州");
            params.addSort("test_age",SolrQuery.ORDER.desc);
            params.set("df","test_name");
            //params.set("fl","test_name,test_age,test_address");
            QueryResponse response = solrClient.query(params);
            SolrDocumentList results = response.getResults();
            ApiResult result = ApiResult.SUCCESS();
            result.setData(results);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ApiResult.FAIL();
    }

}
