package com.wujun.boot.dao;

import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: Jun.Wu
 * @Date: 2018-10-24 15:10
 * @Description:
 */
@Repository("solrDao")
@Scope("prototype")
public class SolrDao {

    @Autowired
    private CloudSolrClient client;

    private QueryResponse response;

    private SolrDocumentList results;

    private static final String SolrName = "demo_collection";

    /**
     * @param query  查询关键字
     * @param offset 起始位置
     * @param limit  每次查询条数
     * @param c      实体类对象
     * @param bool   是否关闭Solr链接
     * @param qf     搜索关键字匹配某些字段的打分比其他的字段要高
     * @param pf     对于某些字段，搜索字符串的密集度(phrase)的打分中占的比重
     * @param solrFl 指定需要返回的字段 逗号分隔
     * @param fq     指定过滤条件
     * @return
     * @throws Exception
     */
    public List getSolrData(String query, String offset, String limit, String c, Boolean bool, String qf, String pf, String solrFl, String fq) throws Exception {
        client.setDefaultCollection(SolrName);
        ModifiableSolrParams params = new ModifiableSolrParams();
        List beans = null;
        //如果limit为空 或者 超过限定抓取数量 那么返回null
        if (null == limit || "".equals(limit)) {
            return null;
        }
        params.set("q", query);
        params.set("wt", "json");
        params.set("start", "0");
        params.set("rows", limit);
        params = checkNotNull(params, offset, limit, qf, pf, solrFl, fq);
        response = client.query(params, SolrRequest.METHOD.POST);
        if (null == c || "".equals(c)) {
            beans = response.getResults();
        } else {
            beans = response.getBeans(Class.forName(c));
            if (null == beans || beans.size() == 0) {
                beans = new ArrayList<>();
                beans.add(Class.forName(c).newInstance());
            }
        }
        return beans;
    }

    /**
     * 验证Solr查询是否有优化
     *
     * @param params 参数关键字
     * @param offset 起始位置
     * @param limit  请求数据条数
     * @param qf     匹配权重
     * @param pf     出现字数权重
     * @param solrFl 需要返回的字段
     * @param fq     过滤哪些数据
     * @return
     */
    private ModifiableSolrParams checkNotNull(ModifiableSolrParams params, String offset, String limit, String qf, String pf, String solrFl, String fq) {
        if (null != offset && !"".equals(offset)) {
            params.set("start", offset);
        }
        if (null != limit && !"".equals(limit)) {
            if (Integer.parseInt(limit) >= 200) {
                limit = "200";
            }
            params.set("rows", limit);
        }
        if (null != qf && !"".equals(qf)) {
            params.set("qf", qf);
            params.set("defType", "dismax");
        }
        if (null != pf && !"".equals(pf)) {
            params.set("pf", pf);
            params.set("defType", "dismax");
        }
        if (null != solrFl && !"".equals(solrFl)) {
            params.set("fl", solrFl);
            params.set("defType", "dismax");
        }
        if (null != fq && !"".equals(fq)) {
            params.set("fq", fq);
            params.set("defType", "dismax");
        }
        return params;
    }

    /**
     * 针对集合数据对Solr进行数据索引
     *
     * @param li
     * @param bool
     * @throws Exception
     */
    public void saveSolrDataList(List<Object> li, Boolean bool) throws Exception {
        if (null != li && li.size() > 0) {
            client.setDefaultCollection(SolrName);
            client.addBeans(li);
        }
    }

    /**
     * 根据索引ID查询solr数据
     *
     * @param id
     * @throws Exception
     */
    public SolrDocument getSolrDataById(String id, Boolean bool) throws Exception {
        client.setDefaultCollection(SolrName);
        SolrDocument so = client.getById(id);
        return so;
    }

    /**
     * 针对单个数据对Solr进行数据索引
     *
     * @param bean
     * @throws Exception
     */
    public void saveSolrData(Object bean, Boolean bool) throws Exception {
        if (null != bean) {
            client.setDefaultCollection(SolrName);
            client.addBean(bean);
        }
    }

    /**
     * 根据集合删除所有索引文档
     *
     * @param li
     * @throws Exception 2017年10月2日
     *                   mazkc
     */
    public void delSolrDataList(List<String> li, Boolean bool) throws Exception {
        if (null != li && li.size() > 0) {
            client.setDefaultCollection(SolrName);
            client.deleteById(li);
            client.commit();
        }
    }

    /**
     * 批量删除所有索引文档
     *
     * @param query
     * @throws Exception
     */
    public void delSolrDataAll(String query, Boolean bool) throws Exception {
        client.setDefaultCollection(SolrName);
        client.deleteByQuery(query);
        client.commit();
    }


    /**
     * 判断搜索总数
     *
     * @param query
     * @throws Exception
     */
    public int checkSolrIndex(String query, boolean bool) throws Exception {
        client.setDefaultCollection(SolrName);
        ModifiableSolrParams params = new ModifiableSolrParams();
        params.set("q", query);
        params.set("wt", "json");
        response = client.query(params);
        String str = String.valueOf(response.getResponse().get("response"));
        String count = "numFound=";
        return Integer.parseInt(str.substring(str.indexOf(count) + count.length(), str.indexOf(",")));
    }

    /**
     * 根据ID删除所有索引文档
     *
     * @param id
     * @throws Exception
     */
    public void delSolrDataId(String id, Boolean bool) throws Exception {
        client.setDefaultCollection(SolrName);
        client.deleteById(id);
        client.commit();
    }

    /**
     * 根据索引ID更新索引数据
     *
     * @param map
     * @throws Exception
     */
    public void updateSolrData(String queryId, HashMap<String, Object> map, Boolean bool) throws Exception {
        client.setDefaultCollection(SolrName);
        SolrInputDocument doc = new SolrInputDocument();
        SolrDocument sd = getSolrDataById(queryId, false);
        if (null != sd) {
            Iterator<String> it = sd.keySet().iterator();
            String key = "";
            //获取所有源数据信息
            while (it.hasNext()) {
                key = it.next();
                doc.addField(key, sd.getFieldValue(key));
            }
            Iterator<String> itt = map.keySet().iterator();
            //将需要更新的数据补充进源数据
            while (itt.hasNext()) {
                key = itt.next();
                doc.remove(key);
                doc.addField(key, map.get(key));
            }
            //doc.remove("id");
            doc.remove("_version_");
            client.add(doc);
        }
    }

    private SolrInputDocument checkDoc(HashMap<String, Object> map, SolrInputDocument doc) {
        if (null != map && null != doc) {
            String key = "";
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                key = it.next();
                doc.addField(key, map.get(key));
            }
        }
        return doc;
    }

}
