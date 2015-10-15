package hashwork.domain.office;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class LocationAddress implements Serializable {
    private String id;
    private String postalAddress;
    private String physicalAddress;
    private String contactNumber;
    private String postalCode;
    private String emailAddress;

    public String getPostalAddress() {
        return postalAddress;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    private LocationAddress() {
    }

    private LocationAddress(Builder builder){
        this.id = builder.id;
        this.postalAddress = builder.postalAddress;
        this.physicalAddress = builder.physicalAddress;
        this.contactNumber = builder.contactNumber;
        this.postalCode = builder.postalCode;
        this.emailAddress = builder.emailAddress;
    }

    public static class Builder{
        private String id;
        private String postalAddress;
        private String physicalAddress;
        private String contactNumber;
        private String postalCode;
        private String emailAddress;

        public Builder postalAddress(String value) {
            this.postalAddress = value;
            return this;
        }

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder physicalAddress(String value){
            this.physicalAddress = value;
            return this;
        }

        public Builder contactNumber(String value){
            this.contactNumber = value;
            return this;
        }

        public Builder postalCode(String value){
            this.postalCode = value;
            return this;
        }

        public Builder emailAddress(String value){
            this.emailAddress = value;
            return this;
        }

        public Builder copy(LocationAddress value) {
            this.id = value.id;
            this.postalAddress = value.postalAddress;
            this.physicalAddress = value.physicalAddress;
            this.contactNumber = value.contactNumber;
            this.postalCode = value.postalCode;
            this.emailAddress = value.emailAddress;
            return this;
        }

        public LocationAddress build() {
            return new LocationAddress(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationAddress that = (LocationAddress) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
