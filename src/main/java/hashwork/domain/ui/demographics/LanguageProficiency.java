package hashwork.domain.ui.demographics;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class LanguageProficiency implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String proficiency;

    public String getId() {
        return id;
    }

    public String getProficiency() {
        return proficiency;
    }

    private LanguageProficiency(){}

    private LanguageProficiency(Builder builder){
        this.id = builder.id;
        this.proficiency = builder.proficiency;

    }

    public static class Builder{
        private String id;
        private String proficiency;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder proficiency(String value){
            this.proficiency = value;
            return this;
        }

        public Builder copy(LanguageProficiency value) {
            this.id = value.id;
            this.proficiency = value.proficiency;
            return this;
        }

        public LanguageProficiency build() {
            return new LanguageProficiency(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LanguageProficiency)) return false;

        LanguageProficiency that = (LanguageProficiency) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return !(getProficiency() != null ? !getProficiency().equals(that.getProficiency()) : that.getProficiency() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getProficiency() != null ? getProficiency().hashCode() : 0);
        return result;
    }
}
