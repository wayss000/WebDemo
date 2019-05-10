package org.knight.web.test;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.junit.Test;
import org.knight.search.ESClient;

import java.net.UnknownHostException;

/**
 * ES测试类
 *
 * @author Wayss.
 * @date 2019/5/10.
 */
public class TestElasticSearch extends BaseTest {

    private String index = "people";
    private String type = "people";

    @Test
    public void testGetES(){
        try {
            Client esClient = ESClient.getESClient();
            GetResponse response = esClient.prepareGet(index, type, "1").get();
            String str = response.getSourceAsString();
            System.out.println(str);

            esClient.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
