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

    public String getId() {
        return id;
    }

    public String getAddressTypeName() {
        return addressTypeName;
    }

    private AddressType() {
    }

    private AddressType(Builder builder){
        this.id = builder.id;
        this.addressTypeName = builder.addressTypeName;
    }

    public static class Builder{
        private String id;
        private String addressTypeName;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder addressTypeName(String value){
            this.addressTypeName = value;
            return this;
        }

        public Builder copy(AddressType value) {
            this.id = value.id;
            this.addressTypeName = value.addressTypeName;
            return this;
        }

        public AddressType build() {
            return new AddressType(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressType)) return false;

        AddressType that = (AddressType) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return !(getAddressTypeName() != null ? !getAddressTypeName().equals(that.getAddressTypeName()) : that.getAddressTypeName() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAddressTypeName() != null ? getAddressTypeName().hashCode() : 0);
        return result;
    }
}
