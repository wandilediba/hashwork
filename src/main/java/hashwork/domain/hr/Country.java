/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.domain.hr;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created By: Garran Michaels
 * Date Create: 05 August 2015
 */

public class Country implements Serializable{

    private Long id; 
    private String country;
    private List<Region> region;
    
    private Country() {
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }
    
    public Country(Country.Builder builder) {
        id=builder.id;
        country=builder.country;
        region=builder.region;
    }
    
    public static class Builder{
        private Long id; 
        private String country;
        private List<Region> region;
        
        public Builder(String country) {
            this.country = country;
        }
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }      
        
        public Builder region(List<Region> value){
            this.region=value;
            return this;
        }
       
        public Builder copy(Country value){
            this.id=value.id;
            this.country=value.country;
            this.region=value.region;
            return this;
        }
        
        public Country build(){
            return new Country(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Country other = (Country) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
