package com.peanuts.community.common.config;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.Node;
import org.elasticsearch.client.NodeSelector;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClient.FailureListener;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.sniff.ElasticsearchNodesSniffer;
import org.elasticsearch.client.sniff.ElasticsearchNodesSniffer.Scheme;
import org.elasticsearch.client.sniff.Sniffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.peanuts.community.data.repository.es.ElasticsearchClient;


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
@ConditionalOnProperty(name = "peanuts.data.elasticsearch.es-connection-type", havingValue = "REST")
public class ElasticsearchRestConfig {
    @Autowired
    private EsConnectionInfo esConnectionInf;

    @Bean(destroyMethod = "close")
    public RestHighLevelClient restHighLevelClient() {
        RestClientBuilder restClientBuilder = restClientBuilder();
        return restClientBuilder == null ? null : new RestHighLevelClient(restClientBuilder);
    }

    private RestClientBuilder restClientBuilder() {
        HttpHost[] httpHosts = buildHttpHosts();
        if (httpHosts == null || httpHosts.length == 0) {
            return null;
        }
        RestClientBuilder restClientBuilder = RestClient.builder(httpHosts);
        restClientBuilder.setDefaultHeaders(buildHeaders());
        restClientBuilder.setFailureListener(buildFailureListener());
        restClientBuilder.setMaxRetryTimeoutMillis(10000);
        restClientBuilder.setNodeSelector(NodeSelector.SKIP_DEDICATED_MASTERS);
        // restClientBuilder.setPathPrefix("");
        // restClientBuilder.setHttpClientConfigCallback(buildHttpClientConfigCallback());
        // restClientBuilder.setRequestConfigCallback(buildRequestConfigCallback());
        return restClientBuilder;
    }

    private HttpHost[] buildHttpHosts() {
        List<EsNode> esNodes = null;
        if (esConnectionInf == null || (esNodes = esConnectionInf.getNodes()) == null || esNodes.isEmpty()) {
            return null;
        }
        HttpHost[] httpHosts = new HttpHost[esNodes.size()];
        httpHosts = esNodes.stream().map(node -> new HttpHost(node.getHost(), node.getPort(), node.getScheme()))
                .collect(Collectors.toList()).toArray(httpHosts);
        return httpHosts;
    }

    private Header[] buildHeaders() {
        Header[] defaultHeaders = new Header[] { new BasicHeader("Content-Type", "application/json") };
        return defaultHeaders;
    }

    private FailureListener buildFailureListener() {
        FailureListener failueListener = new FailureListener() {

            @Override
            public void onFailure(Node node) {
                super.onFailure(node);
            }

        };
        return failueListener;
    }

//    private NodeSelector buildNodeSelector() {
//        return new NodeSelector() {
//            private final Logger LOG = LoggerFactory.getLogger(NodeSelector.class);
//            @Override
//            public void select(Iterable<Node> nodes) {
//                Iterator<Node> iterator = null;
//                if (nodes == null || !(iterator = nodes.iterator()).hasNext()) {
//                    return;
//                }
//                Node node = null;
//                while (iterator.hasNext() && (node = iterator.next()) != null) {
//                    if (node.getName().startsWith("Rp")) {
//                        iterator.remove();
//                    }
//                }
//            }
//        };
//    }
//
//    private HttpClientConfigCallback buildHttpClientConfigCallback() {
//        // 生成SSLContext
//        SSLContext sslContext = buildSSLContext();
//        // 生成CredentialsProvider
//        CredentialsProvider credentialsProvider = buildCredentialsProvider();
//        return new HttpClientConfigCallback() {
//            @Override
//            public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
//                httpClientBuilder.setSSLContext(sslContext);
//
//                httpClientBuilder.disableAuthCaching();
//                httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
//
//                List<Header> defaultHeaders = new ArrayList<>();
//                defaultHeaders.add(new BasicHeader("Authenication", esConnectionInf.getSsl().getToken()));
//                httpClientBuilder.setDefaultHeaders(defaultHeaders);
//
//                httpClientBuilder.setDefaultIOReactorConfig(IOReactorConfig.custom().setIoThreadCount(1).build());
//                return httpClientBuilder;
//            }
//        };
//    }
//
//    private CredentialsProvider buildCredentialsProvider() {
//        final EsSslInfo esSslInfo = esConnectionInf.getSsl();
//        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY,
//                new UsernamePasswordCredentials(esSslInfo.getUsername(), esSslInfo.getPassword()));
//        return credentialsProvider;
//    }
//
//    private SSLContext buildSSLContext() {
//        SSLContext sslContext = null;
//        final EsSslInfo esSslInfo = esConnectionInf.getSsl();
//        try {
//            KeyStore truststore = KeyStore.getInstance(esSslInfo.getKeyStoreName());
//            try (InputStream is = Files.newInputStream(Paths.get(esSslInfo.getKeyStoreFilePath()))) {
//                truststore.load(is, esSslInfo.getKeyStorePassword().toCharArray());
//            }
//            SSLContextBuilder sslBuilder = SSLContexts.custom().loadTrustMaterial(truststore, null);
//            sslContext = sslBuilder.build();
//        } catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException | CertificateException
//                | IOException e) {
//        }
//        return sslContext;
//    }
//    
//    private RequestConfigCallback buildRequestConfigCallback() {
//        return new RequestConfigCallback() {
//
//            @Override
//            public Builder customizeRequestConfig(Builder requestConfigBuilder) {
//                return requestConfigBuilder;
//            }
//        };
//    }

    @Bean(destroyMethod = "close")
    public Sniffer sniffer(RestHighLevelClient restHighLevelClient) {
        RestClient restClient = restHighLevelClient.getLowLevelClient();
        ElasticsearchNodesSniffer esNodesSniffer = new ElasticsearchNodesSniffer(restClient, 2000, Scheme.HTTP);
        Sniffer sniffer = Sniffer.builder(restClient).setSniffIntervalMillis(60000)
                .setSniffAfterFailureDelayMillis(30000).setNodesSniffer(esNodesSniffer).build();
        return sniffer;
    }
    
    @Bean
    public ElasticsearchClient elasticsearchClient(RestHighLevelClient restHighLevelClient) {
        return ElasticsearchClient.adapt(restHighLevelClient);
    }
}
