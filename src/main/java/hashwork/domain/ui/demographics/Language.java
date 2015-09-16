package hashwork.domain.ui.demographics;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Language implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private Language(){}
    private Language(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
    }

    public static class Builder{
        private String id;
        private String name;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder name(String value){
            this.name = value;
            return this;
        }

        public Builder copy(Language value) {
            this.id = value.id;
            this.name = value.name;
            return this;
        }

        public Language build() {
            return new Language(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Language)) return false;

        Language language = (Language) o;

        if (getId() != null ? !getId().equals(language.getId()) : language.getId() != null) return false;
        return !(getName() != null ? !getName().equals(language.getName()) : language.getName() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
