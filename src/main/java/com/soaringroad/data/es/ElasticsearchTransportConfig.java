package com.soaringroad.data.es;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.soaringroad.common.PeanutsException;
import com.soaringroad.data.rdb.RdbConfig;

/**
 * <pre>
 * Spring Configuration for ElasticSearch
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/02
 */
@Configuration
@AutoConfigureAfter(RdbConfig.class)
@ConditionalOnProperty(name = "peanuts.data.elasticsearch.es-connection-type", havingValue = "TRANSPORT")
public class ElasticsearchTransportConfig {
    @Autowired
    private EsConnectionInfo esConnectionInf;

    @Bean(destroyMethod = "close")
    public TransportClient transportClient() {
        Settings settings = Settings.builder().put("cluster.name", esConnectionInf.getCluster())
                .put("client.transport.sniff", false).build();
        TransportClient client = new PreBuiltTransportClient(settings);
        esConnectionInf.getNodes().stream().map(node -> {
            InetAddress inetAddress = null;
            try {
                inetAddress = InetAddress.getByName(node.getHost());
            } catch (UnknownHostException e) {
                throw new PeanutsException(e);
            }
            return new TransportAddress(inetAddress, 9300);
        }).forEach(address -> client.addTransportAddress(address));
        return client;
    }

    @Bean
    public ElasticsearchClient elasticsearchClient(TransportClient transportClient) {
        return ElasticsearchClient.adapt(transportClient);
    }
}
