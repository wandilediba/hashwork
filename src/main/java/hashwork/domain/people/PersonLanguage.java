package hashwork.domain.people;

import java.io.Serializable;

/**
 * Created by Bongani on 2015/08/22.
 */
public class PersonLanguage implements Serializable {
    private String id;
    private String personId;
    private String languageId;
    private String reading;
    private String writing;
    private String speaking;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getLanguageId() {
        return languageId;
    }

    public String getReading() {
        return reading;
    }

    public String getWriting() {
        return writing;
    }

    public String getSpeaking() {
        return speaking;
    }
    
    private PersonLanguage(){}
    
    
        public PersonLanguage(Builder builder) {
        this.id = builder.id;
        this.personId = builder.personId;
        this.languageId = builder.languageId;
        this.reading = builder.reading;
        this.writing = builder.writing;
         this.speaking = builder.speaking;
        
    }

    public static class Builder{

        private String id;
        private String personId;
        private String languageId;
        private String reading;
        private String writing;
        private String speaking;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.personId = value;
            return this;
        }

        public Builder languageId(String value){
            this.languageId  = value;
            return this;
        }

        public Builder reading(String value){
            this.reading = value;
            return this;
        }

        public Builder writing(String value){
            this.writing = value;
            return this;
        }
         public Builder speaking(String value){
            this.speaking = value;
            return this;
        }

        public Builder copy(PersonLanguage value){
            this.id =  value.id;
            this.personId = value.personId;
            this.languageId = value.languageId;
            this.reading = value.reading;
            this.writing = value.writing;
            this.speaking = value.speaking;
            return this;
        }

        public PersonLanguage build(){
            return new PersonLanguage(this);
        }

    }
            
}
