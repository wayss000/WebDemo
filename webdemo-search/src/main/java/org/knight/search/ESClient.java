package org.knight.search;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ES客户端
 *
 * @author Wayss.
 * @date 2019/5/10.
 */
public class ESClient {

    public static Client getESClient() throws UnknownHostException {

        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", "elasticsearch").build();

        Client client = TransportClient.builder().settings(settings).build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.125.129"), 9300));

        return client;
    }
}
