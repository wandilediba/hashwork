package hashwork.domain.people;

import java.io.Serializable;

/**
 * Created by Bongani on 2015/08/22.
 */
public class PersonRole implements Serializable {
    private String id;
    private String persondId;
    private String roleId;

    public String getId() {
        return id;
    }
    public String getPersondId() {
        return persondId;
    }
    public String getRoleId() {
        return roleId;
    }
    
    public PersonRole (Builder builder){
        this.id = builder.id;
        this.persondId = builder.persondId;
        this.roleId = builder.roleId;       
     }
     
        public static class Builder{
        private String id;
        private String persondId;
        private String roleId;
        
        public Builder id(String value){
            this.id = value;
            return this;
        }
        
        public Builder persondId(String value){
            this.persondId = value;
            return this;
        }
        
        public Builder roleId(String value){
            this.roleId = value;
            return this;
        }
        
         public Builder copy(PersonRole value){
            this.id = value.id;
            this.persondId = value.persondId;
            this.roleId = value.roleId;            
            return this;
        }
         
   }
        public static Builder builder() {
        return new Builder();
    }
}
