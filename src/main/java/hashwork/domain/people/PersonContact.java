package hashwork.domain.people;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PersonContact implements Serializable {
    private String id;
    private String personId;
    private String addressTypeId;
    private String contactValue;
    private String status;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getAddressTypeId() {
        return addressTypeId;
    }

    public String getContactValue() {
        return contactValue;
    }

    public String getStatus() {
        return status;
    }

    private PersonContact()
    {
      // empty constructor
    }
    public PersonContact(Builder builder) {
        this.id = builder.id;
        this.personId = builder.personId;
        this.addressTypeId = builder.addressTypeId;
        this.contactValue = builder.contactValue;
        this.status = builder.status;
    }

    public static class Builder{

        private String id;
        private String personId;
        private String addressTypeId;
        private String contactValue;
        private String status;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.id = value;
            return this;
        }

        public Builder addressTypeId(String value){
            this.id  = value;
            return this;
        }

        public Builder contactValue(String value){
            this.contactValue = value;
            return this;
        }

        public Builder status(String value){
            this.status = value;
            return this;
        }

        public Builder copy(PersonContact value){
            this.id =  value.id;
            this.personId = value.personId;
            this.addressTypeId = value.addressTypeId;
            this.status = value.status;
            this.contactValue = value.contactValue;
            return this;
        }

        public PersonContact build(){
            return new PersonContact(this);
        }
    }
}
