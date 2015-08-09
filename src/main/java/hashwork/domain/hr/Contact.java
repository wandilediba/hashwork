/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.domain.hr;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * Created By: Garran Michaels
 * Date Create: 05 August 2015
 */

@Embeddable
public class Contact implements Serializable{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id; 
    private String mobileNumber;
    private String homeNumber;
    private String emailAddress;
    
    private Contact() {
    }

//    public Long getId() {
//        return id;
//    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    
    public Contact(Contact.Builder builder) {
//        id=builder.id;
        mobileNumber=builder.mobileNumber;
        homeNumber=builder.homeNumber;
        emailAddress=builder.emailAddress;
    }
    
    public static class Builder{
        private Long id; 
        private String mobileNumber;
        private String homeNumber;
        private String emailAddress;
        
        public Builder(Long id) {
            this.id = id;
        }
        
        public Builder mobileNumber(String value){
            this.mobileNumber=value;
            return this;
        }
        
        public Builder homeNumber(String value){
            this.homeNumber=value;
            return this;
        }
        
        public Builder emailAddress(String value){
            this.emailAddress=value;
            return this;
        }
        
        public Builder copy(Contact value){
//            this.id=value.id;
            this.mobileNumber=value.mobileNumber;
            this.homeNumber=value.homeNumber;
            this.emailAddress=value.emailAddress;
            return this;
        }
        
        public Contact build(){
            return new Contact(this);
        }
    }
}
