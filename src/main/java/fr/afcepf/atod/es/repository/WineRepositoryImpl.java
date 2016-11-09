package fr.afcepf.atod.es.repository;

import java.util.List;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MatchQueryBuilder.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import fr.afcepf.atod.es.dao.api.WineRepositoryCustom;
import fr.afcepf.atod.es.domain.Wine;

public class WineRepositoryImpl implements WineRepositoryCustom {
    @Autowired
    private ElasticsearchOperations esTemplate;
    
    @Override
    public void deleteIndex() {
        esTemplate.deleteIndex(Wine.class);
    }

    @Override
    public List<Wine> listByWineFeatureId(Integer id) {
        QueryBuilder builder = QueryBuilders.nestedQuery("features", QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("features.id",id)));
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).withPageable(new PageRequest(0,200)).build();
        return esTemplate.queryForList(searchQuery,Wine.class);
    }

    @Override
    public List<Wine> searchByStringQuery(String paramStr) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery(paramStr, "name")
                .operator(Operator.AND)
                .fuzziness(Fuzziness.ONE)
                .prefixLength(3))
                .withPageable(new PageRequest(0,200))
                .build();
        return esTemplate.queryForList(searchQuery,Wine.class);
    }
    
    
}
