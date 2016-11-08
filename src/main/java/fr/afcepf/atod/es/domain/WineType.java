package fr.afcepf.atod.es.domain;
import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class WineType {
    @Id
    private Integer id;
    private String type;
    private String type_EN;
    
    public WineType(Integer paramId,String paramType) {
        super();
        id=paramId;
        type_EN = paramType;
    }
    public WineType() {
        super();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer paramId) {
        id = paramId;
    }
    public String getType() {
        return type;
    }
    public void setType(String paramType) {
        type = paramType;
    }
    public String getType_EN() {
        return type_EN;
    }
    public void setType_EN(String paramType_EN) {
        type_EN = paramType_EN;
    }
    
}