package hashwork.domain.ui.country;

import java.io.Serializable;

/**
 * Created by garran on 2015/08/31.
 */
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String country;

    public String getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    private Country() {
    }

    private Country(Builder builder) {
        this.id = builder.id;
        this.country = builder.country;
    }

    public static class Builder {
        private String id;
        private String country;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder country(String value) {
            this.country = value;
            return this;
        }

        public Builder copy(Country value) {
            this.id = value.id;
            this.country = value.country;
            return this;
        }

        public Country build() {
            return new Country(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country1 = (Country) o;

        if (getId() != null ? !getId().equals(country1.getId()) : country1.getId() != null) return false;
        return !(getCountry() != null ? !getCountry().equals(country1.getCountry()) : country1.getCountry() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        return result;
    }
}
