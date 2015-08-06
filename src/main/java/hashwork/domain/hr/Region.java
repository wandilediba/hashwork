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
public class Region implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private String region;
    
    private Region() {
    }

    public Long getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }
    
    public Region(Region.Builder builder) {
        id=builder.id;
        region=builder.region;
    }
    
    public static class Builder{
        private Long id; 
        private String region;
        
        public Builder(Long id) {
            this.id = id;
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

    @Override
    public String toString() {
        return "Region{" + "id=" + id + ", region=" + region + '}';
    }
}
