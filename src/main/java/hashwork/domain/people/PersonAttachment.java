package hashwork.domain.people;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PersonAttachment implements Serializable {
    private String id;
    private String personId;
    private String fileName;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getFileName() {
        return fileName;
    }

    public PersonAttachment(){}

    public PersonAttachment(Builder builder){

        this.id = builder.id;
        this.personId = builder.personId;
        this.fileName = builder.fileName;

    }

    public static class Builder{

        private String id;
        private String personId;
        private String fileName;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){

            this.personId = value;
            return this;
        }
        public Builder fileName(String value){
            this.fileName = value;

            return this;
        }

        public Builder copy(PersonAttachment value){

            this.id =  value.id;
            this.fileName = value.fileName;
            this.personId = value.personId;
            return this;
        }
        
        public PersonAttachment build(){
            return new PersonAttachment(this);

        }
    }
    
}
