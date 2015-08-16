/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.domain.hr;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created By: Garran Michaels
 * Date Create: 05 August 2015
 */
public class Department implements Serializable{

    private Long id; 
    private String departmentName;
    private Country country;
    
    private Department() {
    }

    public Long getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Country getCountry() {
        return country;
    }

    public Department(Department.Builder builder) {
        id=builder.id;
        departmentName=builder.departmentName;
        country=builder.country;
    }
    public static class Builder{
        private Long id; 
        private String departmentName;
        private Country country;

        public Builder(String departmentName) {
            this.departmentName = departmentName;
        }
        
        public Builder id(long value){
            this.id=value;
            return this;
        }
        
        public Builder country(Country value){
            this.country=value;
            return this;
        }
        
        public Builder copy(Department value){
            this.id=value.id;
            this.departmentName=value.departmentName;
            this.country=value.country;
            return this;
        }
        
        public Department build(){
            return new Department(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Department other = (Department) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
