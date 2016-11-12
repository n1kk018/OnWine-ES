package fr.afcepf.atod.es.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName="product", type="wine")
@Setting(settingPath = "/settings/settings.json")
@Mapping(mappingPath = "/mappings/mappings.json")
public class Wine {
    @Id
    private Integer id;
    private String name;
    private String appellation_EN;
    private String appellation;
    private Double price;
    private Integer apiId;
    @Field(type = FieldType.Object)
    private WineType type;
    @Field(type = FieldType.Object)
    private WineVintage vintage;
    @Field(type = FieldType.Object)
    private WineVarietal varietal;
    @Field(type = FieldType.Nested)
    private List<WineFeature> features=new ArrayList<WineFeature>();
    public Wine() {
        super();
    }
    public Wine(Integer paramId, String paramName, String paramAppellation_EN, Double paramPrice, Integer paramApiId, WineType paramType,
            WineVintage paramVintage, WineVarietal paramVarietal) {
        super();
        id = paramId;
        name = paramName;
        appellation_EN = paramAppellation_EN;
        price = paramPrice;
        apiId = paramApiId;
        type = paramType;
        vintage = paramVintage;
        varietal = paramVarietal;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer paramId) {
        id = paramId;
    }
    public String getName() {
        return name;
    }
    public void setName(String paramName) {
        name = paramName;
    }
    public String getAppellation() {
        return appellation;
    }
    public void setAppellation(String paramAppellation) {
        appellation = paramAppellation;
    }
    public String getAppellation_EN() {
        return appellation_EN;
    }
    public void setAppellation_EN(String paramAppellation_EN) {
        appellation_EN = paramAppellation_EN;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double paramPrice) {
        price = paramPrice;
    }
    /**
     * @return the apiId
     */
    public Integer getApiId() {
        return apiId;
    }
    /**
     * @param paramApiId the apiId to set
     */
    public void setApiId(Integer paramApiId) {
        apiId = paramApiId;
    }
    public WineType getType() {
        return type;
    }
    public void setType(WineType paramType) {
        type = paramType;
    }
    public WineVintage getVintage() {
        return vintage;
    }
    public void setVintage(WineVintage paramVintage) {
        vintage = paramVintage;
    }
    public WineVarietal getVarietal() {
        return varietal;
    }
    public void setVarietal(WineVarietal paramVarietal) {
        varietal = paramVarietal;
    }
    public List<WineFeature> getFeatures() {
        return features;
    }
    public void setFeatures(List<WineFeature> paramFeatures) {
        features = paramFeatures;
    }
    public void addFeature(WineFeature paramFeature) {
        features.add(paramFeature);
    }
    
    
}
