package fr.afcepf.atod.es.domain;
import java.io.Serializable;


public class WineVintage{
    private String year;
    
    public WineVintage() {
        super();
    }
    
    public WineVintage(String paramYear) {
        super();
        year = paramYear;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String paramYear) {
        year = paramYear;
    } 
    
}