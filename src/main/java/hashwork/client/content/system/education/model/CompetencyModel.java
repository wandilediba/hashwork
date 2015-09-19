package hashwork.client.content.system.education.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/09/05.
 */
public class CompetencyModel implements Serializable, Comparable<CompetencyModel> {
    private static final long serialVersionUID = 1L;

    //competency type Computer Skills, specific competencies could include Data Entry, Software Use and Document Formatting
    private String name;
    private String competencyTypeId;
    private String notes;


    public String getName() {
        return name;
    }
    public String getCompetencyTypeId() {
        return competencyTypeId;
    }
    public String getNotes() {
        return notes;
    }

    private CompetencyModel(Builder builder) {
        this.name = builder.name;
        this.competencyTypeId = builder.competencyTypeId;
        this.notes = builder.notes;
    }

    public static class Builder {
        private String name;
        private String competencyTypeId;
        private String notes;

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder competencyTypeId(String value) {
            this.competencyTypeId = value;
            return this;
        }

        public Builder notes(String value) {
            this.notes = value;
            return this;
        }

        public Builder copy(CompetencyModel value) {
            this.name = value.name;
            this.competencyTypeId = value.competencyTypeId;
            this.notes = value.notes;
            return this;
        }
    }
        @Override
    public int compareTo(CompetencyModel o) {
        return name.compareTo(o.name);
    }
}