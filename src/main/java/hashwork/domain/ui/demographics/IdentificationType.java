package hashwork.domain.ui.demographics;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class IdentificationType implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String idvalue;
    private String description;

    public String getId() {
        return id;
    }

    public String getIdvalue() {
        return idvalue;
    }

    public String getDescription() {
        return description;
    }

    private IdentificationType(){}

    private IdentificationType(Builder builder){
        this.id = builder.id;
        this.idvalue = builder.idvalue;
        this.description = builder.description;

    }

    public static class Builder{
        private String id;
        private String idvalue;
        private String description;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder idvalue(String value){
            this.idvalue = value;
            return this;
        }
        public Builder description(String value){
            this.description = value;
            return this;
        }

        public Builder copy(IdentificationType value) {
            this.id = value.id;
            this.idvalue = value.idvalue;
            this.description = value.description;
            return this;
        }

        public IdentificationType build() {
            return new IdentificationType(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdentificationType)) return false;

        IdentificationType that = (IdentificationType) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getIdvalue() != null ? !getIdvalue().equals(that.getIdvalue()) : that.getIdvalue() != null) return false;
        return !(getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getIdvalue() != null ? getIdvalue().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }
}
