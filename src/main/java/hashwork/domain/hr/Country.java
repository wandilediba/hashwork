/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.domain.hr;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created By: Garran Michaels
 * Date Create: 05 August 2015
 */

@Embeddable
public class Country implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private String country;
    
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
    }
    
    public static class Builder{
        private Long id; 
        private String country;
        
        public Builder(Long id) {
            this.id = id;
        }
        
        public Builder country(String value){
            this.country=value;
            return this;
        }
       
        public Builder copy(Country value){
            this.id=value.id;
            this.country=value.country;
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

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", country=" + country + '}';
    }
}
