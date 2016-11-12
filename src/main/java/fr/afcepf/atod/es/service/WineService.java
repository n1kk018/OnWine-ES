package fr.afcepf.atod.es.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.afcepf.atod.es.dao.api.WineRepositoryCustom;
import fr.afcepf.atod.es.domain.Wine;
import fr.afcepf.atod.es.repository.WineRepository;

@Service
public class WineService {
    @Resource
    WineRepository wineRepo;
    
    public Wine save(Wine wine) {
        return wineRepo.save(wine);
    }
    
    public void deleteIdx() {
        wineRepo.deleteIndex();
    }
    
    public void deleteAll() {
        wineRepo.deleteAll();
    }
    
    public Wine getById(Integer id) {
        return wineRepo.findOne(id);
    }
    
    public List<Wine> findByWineTypeId(Integer id)
    {
        return wineRepo.findByTypeId(id);
    }
    
    public List<Wine> findByWineVarietalId(Integer id)
    {
        return wineRepo.findByVarietalId(id);
    }
    
    public List<Wine> findByWineFeatureId(Integer id)
    {
        return wineRepo.listByWineFeatureId(id);
    }
    
    public List<Wine> searchByStringQuery(String str)
    {
        return wineRepo.searchByStringQuery(str);
    }
    
    public Wine findById(Integer id)
    {
        return wineRepo.findOne(id);
    }
}
