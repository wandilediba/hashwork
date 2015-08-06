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
public class City implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private String city;
    
    private City() {
    }
    
    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }
    
    public City(City.Builder builder) {
        id=builder.id;
        city=builder.city;
    }
    
    public static class Builder{
        private Long id; 
        private String city;
        
        public Builder(Long id) {
            this.id = id;
        }
       
        public Builder copy(City value){
            this.id=value.id;
            this.city=value.city;
            return this;
        }
        
        public City build(){
            return new City(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final City other = (City) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", city=" + city + '}';
    }
}
