package hashwork.domain.people;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PersonDemographics implements Serializable {
    private String id;
    private String personId;
    private String gender;
    private Date dateOfBirth;
    private String maritalStatus;
    private int numberOfDependencies;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public int getNumberOfDependencies() {
        return numberOfDependencies;
    }

    public PersonDemographics(Builder builder){
        this.id = builder.id;
        this.personId = builder.personId;
        this.gender = builder.gender;
        this.dateOfBirth = builder.dateOfBirth;
        this.maritalStatus = builder.maritalStatus;
        this.numberOfDependencies = builder.numberOfDependencies;


    }

    public static class Builder{

        private String id;
        private String personId;
        private String gender;
        private Date dateOfBirth;
        private String maritalStatus;
        private int numberOfDependencies;



        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.personId = value;
            return this;
        }

        public Builder gender(String value){
            this.gender = value;
            return this;
        }

        public Builder dateOfBirth(Date value){
            this.dateOfBirth = value;
            return this;
        }

        public Builder maritalStatus(String value){
            this.maritalStatus = value;
            return this;
        }
        public Builder numberOfDependencies(int value){
            this.numberOfDependencies = value;
            return this;

        }

        public Builder copy(PersonDemographics value){
            this.id = value.id;
            this.personId = value.personId;
            this.gender = value.gender;
            this.dateOfBirth = value.dateOfBirth;
            this.maritalStatus = value.maritalStatus;
            this.numberOfDependencies = value.numberOfDependencies;

            return this;

        }

        public PersonDemographics build(){

            return new PersonDemographics(this);
        }

    }


}
