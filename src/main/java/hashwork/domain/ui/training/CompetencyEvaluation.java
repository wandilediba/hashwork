package hashwork.domain.ui.training;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class CompetencyEvaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    //Attended , Competetent ..
    private String compTypeName;
    private String description;

    private CompetencyEvaluation(){}

    public String getId() {
        return id;
    }

    public String getCompTypeName() {
        return compTypeName;
    }

    public String getDescription() {
        return description;
    }

    private CompetencyEvaluation(Builder builder) {
        this.id = builder.id;
        this.compTypeName = builder.compTypeName;
        this.description = builder.description;

    }

    public static class Builder {
        private String id;
        private String compTypeName;
        private String description;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder compType(String value) {
            this.id = value;
            return this;
        }

        public Builder description(String value) {
            this.id = value;
            return this;
        }

        public Builder copy(CompetencyEvaluation value) {
            this.id = value.id;
            this.compTypeName = value.compTypeName;
            this.description = value.description;
            return this;

        }

        public CompetencyEvaluation build() {
            return new CompetencyEvaluation(this);
        }
    }
}
