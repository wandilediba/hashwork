package hashwork.domain.people;

import java.io.Serializable;


/**
 * Created by Bongani on 2015/08/22.
 */
public class PersonIdentity implements Serializable {
    private String id;
    private String personId;
    private String idType;
    private String idValue;
    private boolean preffered;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getIdType() {
        return idType;
    }

    public String getIdValue() {
        return idValue;
    }

    public boolean isPreffered() {
        return preffered;
    }    
    
    public PersonIdentity() {}
    
     public PersonIdentity (Builder builder){               
        this.id = builder.id;
        this.personId = builder.personId;
        this.idType = builder.idType;
        this.idValue = builder.idValue;
        this.preffered = builder.preffered;
        }
     
        public static class Builder {
        private String id;
        private String personId;
        private String idType;
        private String idValue;
        private boolean preffered;      
        
        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder personId(String value){
            this.personId = value;
            return this;
        }
        
        public Builder idType(String value){
            this.idType = value;
            return this;
        }
        
        public Builder idValue(String value){
            this.idValue = value;
            return this;
        }
         public Builder preffered(boolean value){
            this.preffered = value;
            return this;
        }
        
        public Builder copy(PersonIdentity value){
            this.id = value.id;
            this.personId = value.personId;
            this.idType = value.idType;
            this.idValue = value.idValue;
            this.preffered = value.preffered;
            return this;
        }     
         public PersonIdentity build(){
            return new PersonIdentity(this);

        }
    }
     public static Builder builder() {
        return new Builder();
    }
}
