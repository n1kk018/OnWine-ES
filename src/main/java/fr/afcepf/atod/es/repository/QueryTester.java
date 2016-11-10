package fr.afcepf.atod.es.repository;

import java.util.List;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.MatchQueryBuilder.Operator;
import org.elasticsearch.index.query.MultiMatchQueryBuilder.Type;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import fr.afcepf.atod.es.ElasticsearchConfiguration;
import fr.afcepf.atod.es.domain.Wine;
import fr.afcepf.atod.es.domain.WineFeature;

public class QueryTester  {   
    public static void main(String[] args) {
        BeanFactory bf = new AnnotationConfigApplicationContext(ElasticsearchConfiguration.class);
        ElasticsearchConfiguration conf = bf.getBean(ElasticsearchConfiguration.class);
        String str = "rond chateau";
        QueryBuilder boolQueryBuilder = 
                QueryBuilders.matchQuery(str, "_all").operator(Operator.AND);
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withPageable(new PageRequest(0,200))
                .build();
        List<Wine> list = conf.elasticsearchTemplate().queryForList(searchQuery,Wine.class);
        for (Wine wine : list) {
            System.out.println(wine.getName());
            for (WineFeature feature : wine.getFeatures()) {
                System.out.println(feature.getLabel());
            }
        }
    }

}
