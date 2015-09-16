package hashwork.domain.ui.training;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class TrainingInstitutionTrainer implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String qualification;


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getQualification() {
        return qualification;
    }


    private TrainingInstitutionTrainer(){}

    private TrainingInstitutionTrainer(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.qualification = builder.qualification;
    }

    public static  class Builder{
        private String id;
        private String title;
        private String firstName;
        private String lastName;
        private String qualification;

        public Builder id(String value){
            this.id = value;
            return this;
        }


        public Builder title(String value){
            this.title = value;
            return this;
        }

        public Builder firstName(String value){
            this.firstName = value;
            return this;
        }

        public Builder lastName(String value){
            this.lastName = value;
            return this;
        }

        public Builder qualification(String value){
            this.qualification = value;
            return this;
        }


        public Builder copy(TrainingInstitutionTrainer value) {
            this.id = value.id;
            this.title = value.title;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.qualification = value.qualification;

            return this;
        }

        public TrainingInstitutionTrainer build(){
            return new TrainingInstitutionTrainer(this);
        }
    }
}
