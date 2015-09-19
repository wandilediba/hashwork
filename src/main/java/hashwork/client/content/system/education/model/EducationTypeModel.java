package hashwork.client.content.system.education.model;

import hashwork.domain.ui.education.EducationType;

/**
 * Created by hashcode on 2015/09/05.
 */
public class EducationTypeModel {

    private static final long serialVersionUID = 1L;
    private String id;
    //"Competent," "Not Competent" and "Not Assessed"
    private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private EducationTypeModel(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public static class Builder {
        private String id;
        private String name;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder copy(EducationTypeModel value) {
            this.name = value.name;
            this.id = value.id;
            return this;
        }

    }
}

