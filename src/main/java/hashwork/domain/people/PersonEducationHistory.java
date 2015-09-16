package hashwork.domain.people;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PersonEducationHistory implements Serializable {
    private String id;
    private String personId;
    private String institutionName;
    private String institutionLocation;
    private int yearOfGraduation;
    private String educationTypeId;
    private String degreeId;
    private String notes;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getInstitutionLocation() {
        return institutionLocation;
    }

    public int getYearOfGraduation() {
        return yearOfGraduation;
    }

    public String getEducationTypeId() {
        return educationTypeId;
    }

    public String getDegreeId() {
        return degreeId;
    }

    public String getNotes() {
        return notes;
    }


    private PersonEducationHistory()
    {
    }
        public PersonEducationHistory(Builder builder){
        this.id =  builder.id;
        this.personId = builder.personId;
        this.institutionName = builder.institutionName;
        this.institutionLocation = builder.institutionLocation;
        this.yearOfGraduation = builder.yearOfGraduation;
        this.educationTypeId = builder.educationTypeId;
        this.degreeId = builder.degreeId;
        this.notes = builder.notes;

        }
        public static class Builder{
           
        private String id;
        private String personId;
        private String institutionName;
        private String institutionLocation;
        private int yearOfGraduation;
        private String educationTypeId;
        private String degreeId;
        private String notes;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder personId(String value){
            this.personId = value;
            return this;
        }
        public Builder institutionName(String value){
            this.institutionName = value;
            return this;
        }

        public Builder institutionLocation(String value){
            this.institutionLocation = value;
            return this;
        }
        public Builder yearOfGraduation(int value){
            this.yearOfGraduation = value;
            return this;
        }

        public Builder educationTypeId(String value){
            this.educationTypeId = value;
            return this;
        }

        public Builder degreeId(String value){
            this.degreeId = value;
            return this;

        }
        
         public Builder notes(String value){
            this.notes = value;
            return this;

        }

        public Builder copy(PersonEducationHistory value){

            this.id =  value.id;
            this.personId = value.personId;
            this.institutionName = value.institutionName;
            this.institutionLocation = value.institutionLocation;
            this.yearOfGraduation = value.yearOfGraduation;
            this.educationTypeId = value.educationTypeId;
            this.degreeId = value.degreeId;
            this.notes = value.notes;
            return this;
        }

        public PersonEducationHistory build(){
            return new PersonEducationHistory(this);

        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
