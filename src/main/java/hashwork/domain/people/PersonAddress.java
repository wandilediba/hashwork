package hashwork.domain.people;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PersonAddress implements Serializable {
    private String id;
    private String personId;
    private String description;
    private String postalCode;
    private String addressTypeId;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getDescription() {
        return description;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAddressTypeId() {
        return addressTypeId;
    }

    private  PersonAddress(){}

    public PersonAddress(Builder builder){
        this.id =  builder.id;
        this.personId = builder.personId;
        this.description = builder.description;
        this.postalCode = builder.postalCode;
        this.addressTypeId = builder.addressTypeId;
    }

    public static class Builder{

        private String id;
        private String personId;
        private String description;
        private String postalCode;
        private String addressTypeId;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.id = value;
            return this;
        }

        public Builder description(String value){
            this.description = value;
            return this;
        }
        public Builder addressTypeId(String value){
            this.addressTypeId = value;
            return this;
        }
        
        public Builder postalCode(String value){
            this.postalCode = value;
            return this;
        }

        public Builder copy(PersonAddress value){
            this.id =  value.id;
            this.personId = value.personId;
            this.description = value.description;
            this.postalCode = value.postalCode;
            this.addressTypeId = value.addressTypeId;

            return this;

        }

        public PersonAddress build(){
            return new PersonAddress(this);
        }

    }
    public static Builder builder() {
        return new Builder();
    }
}
