package fr.afcepf.atod.es.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import fr.afcepf.atod.es.dao.api.WineRepositoryCustom;
import fr.afcepf.atod.es.domain.Wine;

public interface WineRepository extends CrudRepository<Wine, Integer>, WineRepositoryCustom {
    List<Wine> findByTypeId(Integer id);
    List<Wine> findByVarietalId(Integer id);
}
