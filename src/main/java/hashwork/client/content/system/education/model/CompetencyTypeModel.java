package hashwork.client.content.system.education.model;

import hashwork.domain.ui.education.CompetencyType;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/09/05.
 */


public class CompetencyTypeModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    // Computer Skills, Client Interaction and Accounting based on Company Competency Model
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

    private CompetencyTypeModel(Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
    }

    public static class Builder {
        private String name;
        private String id;

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder copy(CompetencyTypeModel value) {
            this.name = value.name;
            this.id = value.id;
            return this;
        }

    }

}
