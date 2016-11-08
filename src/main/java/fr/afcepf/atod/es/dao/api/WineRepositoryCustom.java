package fr.afcepf.atod.es.dao.api;

import java.util.List;
import fr.afcepf.atod.es.domain.Wine;

public interface WineRepositoryCustom {
    List<Wine> listByWineFeatureId(Integer Id);

    void deleteIndex();
}
