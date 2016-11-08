package fr.afcepf.atod.es;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "fr.afcepf.atod.es.repository")
@ComponentScan(basePackages = {"fr.afcepf.atod.es.service"})
public class ElasticsearchConfiguration {
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }

    @Bean
    public Client client(){
        Settings settings = Settings.builder()
                                    .put("cluster.name","OnWine")
                                    .put("client.transport.ignore_cluster_name", false)
                                    .put("node.client", true)
                                    .put("client.transport.sniff", true)
                                    .build();
        TransportClient client= new TransportClient.Builder().settings(settings).build();
        try {
            TransportAddress address = new InetSocketTransportAddress(
                    InetAddress.getByName("127.0.0.1"), 9300);
            client.addTransportAddress(address);
        } catch (UnknownHostException paramE) {
            paramE.printStackTrace();
        } 
        return client;
    }
}