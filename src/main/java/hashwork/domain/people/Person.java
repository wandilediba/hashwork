package hashwork.domain.people;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Person implements Serializable, Comparable<Person>{
    private static final long serialVersionUID = 1L;
    private String id;
    private String firstName;
    private String middleName;
    private String emailAddress;
    private String lastName;
    private String title;
    private String authvalue;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthvalue() {
        return authvalue;
    }

    private Person()
    {
    
    }

         public Person(Builder builder){
            this.id =  builder.id;
            this.firstName = builder.firstName;
            this.middleName = builder.middleName;
            this.lastName = builder.lastName;
            this.emailAddress = builder.emailAddress;
            this.authvalue = builder.authvalue;
            this.title = builder.title;

        }
        public static class Builder{
            private String id;
            private String firstName;
            private String middleName;
            private String lastName;
            private String emailAddress;
            private String title;
            private String authvalue;


        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder firstName(String value){
            this.firstName = value;
            return this;
        }
        public Builder middletName(String value){
            this.middleName = value;
            return this;
        }


        public Builder lastName(String value){
            this.lastName = value;
            return this;
        }
        public Builder emailAddress(String value){
            this.emailAddress = value;
            return this;
        }

        public Builder title(String value){
            this.title = value;
            return this;
        }

        public Builder authvalue(String value){
            this.authvalue = value;
            return this;

        }

        public Builder copy(Person value){

            this.id =  value.id;
            this.firstName = value.firstName;
            this.middleName = value.middleName;
            this.lastName = value.lastName;
            this.emailAddress = value.emailAddress;
            this.authvalue = value.authvalue;
            this.title = value.title;
            return this;
        }

        public Person build(){
            return new Person(this);

        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public int compareTo(Person o) {
        return lastName.compareTo(o.lastName);}
}
