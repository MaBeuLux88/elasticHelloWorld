package com.github.elasticHelloWorld;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class App {

    public static void main(String[] args) throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch")
                                    // .put("node.name", "testmaxime")
                                    .put("client.transport.sniff", true).build();

        TransportClient client = new PreBuiltTransportClient(settings).addTransportAddress(
                new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        String json = "{" + "\"user\":\"kimchy\"," + "\"postDate\":\"2013-01-30\"," + "\"message\":\"trying out Elasticsearch\"" + "}";

        IndexResponse response = client.prepareIndex("twitter", "tweet").setSource(json).get();

        System.out.println(response.toString());

        client.close();
    }

}
