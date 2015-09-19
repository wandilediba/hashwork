package hashwork.client.content.system.education.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/09/05.
 */


public class DegreeModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String studyField;
    private String educationTypeId;
    //Bachelor , Diploma , Masters , PhD
    private String degreeName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getStudyField() {
        return studyField;
    }

    public String getEducationTypeId() {
        return educationTypeId;
    }

    public String getDegreeName() {
        return degreeName;
    }

    private DegreeModel(Builder builder) {
        this.id = builder.id;
        this.studyField = builder.studyField;
        this.educationTypeId = builder.educationTypeId;
        this.degreeName = builder.degreeName;
    }

    public static class Builder {
        private String id;
        private String studyField;
        private String educationTypeId;
        private String degreeName;

        public Builder id(String value) {
            this.id = value;
            return this;
        }
        public Builder studyField(String value) {
            this.studyField = value;
            return this;
        }
        public Builder educationType(String value) {
            this.educationTypeId = value;
            return this;
        }
        public Builder degreeName(String value) {
            this.degreeName = value;
            return this;
        }

        public Builder copy(DegreeModel value) {
            this.degreeName = value.degreeName;
            this.id = value.id;
            this.studyField = value.studyField;
            this.educationTypeId = value.educationTypeId;
            return this;
        }

    }
}