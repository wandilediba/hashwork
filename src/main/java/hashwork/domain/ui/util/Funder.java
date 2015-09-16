package hashwork.domain.ui.util;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Funder implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String trainingFunderName;
    private String costCenter;
    private String cityId;
    private String LocationContactId;

    private Funder(){}

    public String getId() {
        return id;
    }

    public String getTrainingFunderName() {
        return trainingFunderName;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public String getCityId() {
        return cityId;
    }

    public String getLocationContactId() {
        return LocationContactId;
    }

    private Funder(Builder builder) {
        this.id = builder.id;
        this.trainingFunderName = builder.trainingFunderName;
        this.cityId = builder.cityId;
        this.LocationContactId = builder.LocationContactId;
        this.costCenter = builder.costCenter;
    }


    public static class Builder {
        private String id;
        private String trainingFunderName;
        private String costCenter;
        private String cityId;
        private String LocationContactId;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder trainingFunderName(String value) {
            this.trainingFunderName = value;
            return this;
        }

        public Builder costCenter(String value) {
            this.costCenter = value;
            return this;
        }

        public Builder cityId(String value) {
            this.cityId = value;
            return this;
        }

        public Builder LocationContactId(String value) {
            this.LocationContactId = value;
            return this;
        }

        public Builder copy(Funder value) {
            this.id = value.id;
            this.trainingFunderName = value.trainingFunderName;
            this.costCenter = value.costCenter;
            this.cityId = value.cityId;
            this.LocationContactId = value.LocationContactId;
            return this;

        }

        public Funder build() {
            return new Funder(this);
        }
    }
}
