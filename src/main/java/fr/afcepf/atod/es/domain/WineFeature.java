package fr.afcepf.atod.es.domain;
import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class WineFeature{
    @Id
    private Integer id;
    /**
     * description
     */
    private String label;
    /**
     * description_EN
     */
    private String label_EN;
    
    public WineFeature(Integer paramId, String paramLabel) {
        super();
        id = paramId;
        label_EN = paramLabel;
    }
    public WineFeature() {
        super();
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer paramId) {
        id = paramId;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String paramLabel) {
        label = paramLabel;
    }
    public String getLabel_EN() {
        return label_EN;
    }
    public void setLabel_EN(String paramLabel_EN) {
        label_EN = paramLabel_EN;
    }
}
