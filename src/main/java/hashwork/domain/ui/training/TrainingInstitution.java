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
    private String locationContactId;


    public String getId() {
        return id;
    }

    public String getTrainingInstitution() {
        return trainingInstitution;
    }

    public String getCityId() {
        return cityId;
    }

    public String getLocationContactId() {
        return locationContactId;
    }

    private TrainingInstitution(){}

    private TrainingInstitution(Builder builder) {
        this.id = builder.id;
        this.trainingInstitution = builder.trainingInstitution;
        this.cityId = builder.cityId;
        this.locationContactId = builder.locationContactId;

    }

    public static class Builder {
        private String id;
        private String trainingInstitution;
        private String cityId;
        private String locationContactId;


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

        public Builder locationContactId(String value) {
            this.locationContactId = value;
            return this;
        }

        public Builder copy(TrainingInstitution value) {
            this.id = value.id;
            this.trainingInstitution = value.trainingInstitution;
            this.cityId = value.cityId;
            this.locationContactId = value.locationContactId;

            return this;

        }

        public TrainingInstitution build(){
            return new TrainingInstitution(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainingInstitution that = (TrainingInstitution) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
