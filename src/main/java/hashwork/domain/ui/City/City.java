package hashwork.domain.ui.City;

import java.io.Serializable;

/**
 * Created by garran on 2015/09/05.
 */
public class City implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String city;

    public String getId() {
        return id;
    }

    public String getNumber() {
        return city;
    }

    private City(){}

    private City(Builder builder){
        this.id = builder.id;
        this.city = builder.city;
    }

    public static class Builder{
        private String id;
        private String city;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder city(String value){
            this.city = value;
            return this;
        }

        public Builder copy(City value) {
            this.id = value.id;
            this.city = value.city;
            return this;
        }

        public City build() {
            return new City(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;

        City city1 = (City) o;

        if (getId() != null ? !getId().equals(city1.getId()) : city1.getId() != null) return false;
        return !(city != null ? !city.equals(city1.city) : city1.city != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
