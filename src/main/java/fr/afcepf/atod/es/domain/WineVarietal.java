package fr.afcepf.atod.es.domain;
import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class WineVarietal{
    @Id
    private Integer id;
    private String description;
    private String description_EN;
    
    public WineVarietal() {
        super();
    }
    
    public WineVarietal(Integer paramId,String paramDescription) {
        super();
        id = paramId;
        description_EN = paramDescription;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer paramId) {
        id = paramId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String paramDescription) {
        description = paramDescription;
    }
    public String getDescription_EN() {
        return description_EN;
    }
    public void setDescription_EN(String paramDescription_EN) {
        description_EN = paramDescription_EN;
    }
    
}