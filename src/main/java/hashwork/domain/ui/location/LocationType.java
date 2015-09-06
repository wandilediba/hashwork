package hashwork.domain.ui.location;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class LocationType implements Serializable {
    //Country City Province

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String code;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    private LocationType(){

    }
    private LocationType(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.code = builder.code;
    }

    public static class Builder{
        private String id;
        private String name;
        private String code;

        public Builder id(String value){
            this.id = value;
            return  this;
        }
        public Builder name(String value){
            this.name = value;
            return  this;
        }
        public Builder code(String value){
            this.code = value;
            return  this;
        }

        public Builder copy(LocationType value) {
            this.id = value.id;
            this.name = value.name;
            this.code = value.code;
            return this;
        }

        public LocationType build(){
            return new LocationType(this);
        }
    }

    @Override
    public String toString() {
        return "LocationType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationType)) return false;

        LocationType that = (LocationType) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return !(getCode() != null ? !getCode().equals(that.getCode()) : that.getCode() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
        return result;
    }
}
