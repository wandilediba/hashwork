package hashwork.domain.ui.location;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String code;
    private String latitude;
    private String longitude;
    private String locationTypeId;
    private List<String> childrenIds; // Province has Cities as Children
    private String parentId; //Location Id of Parent, e.g Country --> Province-->City

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLocationTypeId() {
        return locationTypeId;
    }

    public List<String> getChildrenIds() {
        return childrenIds;
    }

    public String getParentId() {
        return parentId;
    }

    private Location(){

    }

    private Location(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.code = builder.code;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.locationTypeId = builder.locationTypeId;
        this.childrenIds = builder.childrenIds;
        this.parentId = builder.parentId;
    }

    public static class Builder{
        private String id;
        private String name;
        private String code;
        private String latitude;
        private String longitude;
        private String locationTypeId;
        private List<String> childrenIds; // Province has Cities as Children
        private String parentId; //Location Id of Parent, e.g Country --> Province-->City

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
        public Builder latitude(String value){
            this.latitude = value;
            return  this;
        }
        public Builder longitude(String value){
            this.longitude = value;
            return  this;
        }
        public Builder locationTypeId(String value){
            this.locationTypeId = value;
            return  this;
        }
        public Builder childrenIds(List<String> value){
            this.childrenIds = value;
            return  this;
        }
        public Builder parentId(String value){
            this.parentId = value;
            return  this;
        }


        public Builder copy(Location value) {
            this.id = value.id;
            this.name = value.name;
            this.code = value.code;
            this.latitude = value.latitude;
            this.longitude = value.longitude;
            this.locationTypeId = value.locationTypeId;
            this.childrenIds = value.childrenIds;
            this.parentId = value.parentId;

            return this;
        }

        public Location build(){
            return new Location(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        if (getId() != null ? !getId().equals(location.getId()) : location.getId() != null) return false;
        if (getName() != null ? !getName().equals(location.getName()) : location.getName() != null) return false;
        if (getCode() != null ? !getCode().equals(location.getCode()) : location.getCode() != null) return false;
        if (getLatitude() != null ? !getLatitude().equals(location.getLatitude()) : location.getLatitude() != null)
            return false;
        if (getLongitude() != null ? !getLongitude().equals(location.getLongitude()) : location.getLongitude() != null)
            return false;
        if (getLocationTypeId() != null ? !getLocationTypeId().equals(location.getLocationTypeId()) : location.getLocationTypeId() != null)
            return false;
        if (getChildrenIds() != null ? !getChildrenIds().equals(location.getChildrenIds()) : location.getChildrenIds() != null)
            return false;
        return !(getParentId() != null ? !getParentId().equals(location.getParentId()) : location.getParentId() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
        result = 31 * result + (getLatitude() != null ? getLatitude().hashCode() : 0);
        result = 31 * result + (getLongitude() != null ? getLongitude().hashCode() : 0);
        result = 31 * result + (getLocationTypeId() != null ? getLocationTypeId().hashCode() : 0);
        result = 31 * result + (getChildrenIds() != null ? getChildrenIds().hashCode() : 0);
        result = 31 * result + (getParentId() != null ? getParentId().hashCode() : 0);
        return result;
    }
}
