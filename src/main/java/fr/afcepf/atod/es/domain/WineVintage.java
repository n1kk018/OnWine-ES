package fr.afcepf.atod.es.domain;
import java.io.Serializable;


public class WineVintage{
    private Integer year;
    
    public WineVintage() {
        super();
    }
    
    public WineVintage(Integer paramYear) {
        super();
        year = paramYear;
    }

    public Integer getYear() {
        return year;
    }
    public void setYear(Integer paramYear) {
        year = paramYear;
    } 
    
}