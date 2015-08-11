/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.domain.hr;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Created By: Garran Michaels
 * Date Create: 05 August 2015
 */

@Entity
public class Region implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private String region;
    @OneToMany (cascade=CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private List<City> city;
    
    private Region() {
    }

    public Long getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

    public List<City> getCity() {
        return city;
    }
    
    public Region(Region.Builder builder) {
        id=builder.id;
        region=builder.region;
        city=builder.city;
    }
    
    public static class Builder{
        private Long id; 
        private String region;
        private List<City> city;
        
        public Builder(String region) {
            this.region = region;
        }
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }
        
        public Builder city(List<City> value){
            this.city=value;
            return this;
        }
       
        public Builder copy(Region value){
            this.id=value.id;
            this.region=value.region;
            return this;
        }
        
        public Region build(){
            return new Region(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Region other = (Region) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
