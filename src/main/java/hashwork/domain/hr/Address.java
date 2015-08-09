/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.domain.hr;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created By: Garran Michaels
 * Date Create: 05 August 2015
 */

@Entity
public class Address implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private String suburb; 
    private String streetName;
    private String Number;
    private String PostalCode;
    
    private Address() {
    }

//    public Long getId() {
//        return id;
//    }

    public String getSuburb() {
        return suburb;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getNumber() {
        return Number;
    }

    public String getPostalCode() {
        return PostalCode;
    }
    
    public Address(Address.Builder builder) {
        id=builder.id;
        suburb=builder.suburb;
        streetName=builder.streetName;
        Number=builder.Number;
        PostalCode=builder.PostalCode;
    }

    public static class Builder{
        private Long id;
        private String suburb;
        private String streetName;
        private String Number;
        private String PostalCode;
     
        public Builder(String PostalCode) {
            this.PostalCode = PostalCode;
        }

        public Builder suburb(String value){
            this.suburb=value;
            return this;
        }
        
        public Builder streetName(String value){
            this.streetName=value;
            return this;
        }
        
        public Builder Number(String value){
            this.Number=value;
            return this;
        }
        
//        public Builder PostalCode(String value){
//            this.PostalCode=value;
//            return this;
//        }
        
        public Builder copy(Address value){
            this.id=value.id;
            this.suburb=value.suburb;
            this.streetName=value.streetName;
            this.Number=value.Number;
            this.PostalCode=value.PostalCode;
            return this;
        }
        
        public Address build(){
            return new Address(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Address other = (Address) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
