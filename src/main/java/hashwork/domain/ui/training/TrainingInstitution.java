package hashwork.domain.ui.training;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class TrainingInstitution implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String trainingInstitution;
    private String cityId;
    private String locationContact;


    public String getId() {
        return id;
    }

    public String getTrainingInstitution() {
        return trainingInstitution;
    }

    public String getCityId() {
        return cityId;
    }

    public String getLocationContact() {
        return locationContact;
    }

    private TrainingInstitution(){}

    private TrainingInstitution(Builder builder) {
        this.id = builder.id;
        this.trainingInstitution = builder.trainingInstitution;
        this.cityId = builder.cityId;
        this.locationContact = builder.locationContact;

    }

    public static class Builder {
        private String id;
        private String trainingInstitution;
        private String cityId;
        private String locationContact;


        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder trainingInstitution(String value) {
            this.trainingInstitution = value;
            return this;
        }

        public Builder cityId(String value) {
            this.cityId = value;
            return this;
        }

        public Builder locationContact(String value) {
            this.locationContact = value;
            return this;
        }

        public Builder copy(TrainingInstitution value) {
            this.id = value.id;
            this.trainingInstitution = value.trainingInstitution;
            this.cityId = value.cityId;
            this.locationContact = value.locationContact;

            return this;

        }

        public TrainingInstitution build(){
            return new TrainingInstitution(this);
        }

    }
}
