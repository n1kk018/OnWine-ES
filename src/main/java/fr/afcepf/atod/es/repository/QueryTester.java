package fr.afcepf.atod.es.repository;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import fr.afcepf.atod.es.ElasticsearchConfiguration;
import fr.afcepf.atod.es.domain.Wine;
import fr.afcepf.atod.es.domain.WineFeature;

public class QueryTester  {    
    public static void main(String[] args) {
        BeanFactory bf = new AnnotationConfigApplicationContext(ElasticsearchConfiguration.class);
        WineRepository repository = bf.getBean(WineRepository.class);
        List<Wine> list = repository.listByWineFeatureId(1);
        for (Wine wine : list) {
            System.out.println(wine.getName());
            for (WineFeature feature : wine.getFeatures()) {
                System.out.println(feature.getLabel_EN());
            }
        }
    }

}
