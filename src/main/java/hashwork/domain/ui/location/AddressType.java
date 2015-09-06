package hashwork.domain.ui.location;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class AddressType implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    //Home Address or Work Address
    private String addressTypeName;

    public String getAddressTypeName() {
        return addressTypeName;
    }

    public String getId() {
        return id;
    }

    private AddressType(){

    }
    private AddressType(Builder builder){
        this.id = builder.id;
        this.addressTypeName = builder.addressTypeName;
    }

    public static class Builder{
        private String id;
        //Home Address or Work Address
        private String addressTypeName;

        public Builder id(String value){
            this.id = value;
            return  this;
        }
        public Builder addressTypeName(String value){
            this.addressTypeName = value;
            return  this;
        }

        public Builder copy(AddressType value) {
            this.id = value.id;
            this.addressTypeName = value.addressTypeName;
            return this;
        }

        public AddressType build(){
            return new AddressType(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressType)) return false;

        AddressType that = (AddressType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return !(addressTypeName != null ? !addressTypeName.equals(that.addressTypeName) : that.addressTypeName != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (addressTypeName != null ? addressTypeName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddressType{" +
                "id='" + id + '\'' +
                ", addressTypeName='" + addressTypeName + '\'' +
                '}';
    }
}
