/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.domain.hr;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created By: Garran Michaels
 * Date Create: 05 August 2015
 */
@Embeddable
public class Department implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private String departmentName;
    
    private Department() {
    }
    
    public Department(Department.Builder builder) {
        id=builder.id;
        departmentName=builder.departmentName;
    }
    public static class Builder{
        private Long id; 
        private String departmentName;
        
        public Builder(Long id) {
            this.id = id;
        }
        
        public Builder departmentName(String value){
            this.departmentName=value;
            return this;
        }
        
        public Builder copy(Department value){
            this.id=value.id;
            this.departmentName=value.departmentName;
            return this;
        }
        
        public Department build(){
            return new Department(this);
        }
    }
    
}
