package hashwork.domain.ui.location;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class LocationAddress implements Serializable {
    //created id value - zamzam

    private static final long serialVersionUID = 1L;
    private String id;
    private String postalAddress;
    private String physicalAddress;
    private String contactNumber;
    private String postalCode;
    private String emailAddress;

    public String getId() {
        return id;
    }

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

    private LocationAddress(){

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

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder postalAddress(String value){
            this.postalAddress= value;
            return  this;
        }
        public Builder physicalAddress(String value){
            this.physicalAddress= value;
            return  this;
        }
        public Builder contactNumber(String value){
            this.contactNumber= value;
            return  this;
        }
        public Builder postalCode(String value){
            this.postalCode= value;
            return  this;
        }
        public Builder emailAddress(String value){
            this.emailAddress= value;
            return  this;
        }

        public Builder copy(LocationAddress value) {
            this.postalAddress = value.postalAddress;
            this.physicalAddress = value.contactNumber;
            this.contactNumber = value.contactNumber;
            this.postalCode = value.postalCode;
            this.emailAddress = value.emailAddress;
            return this;
        }

        public LocationAddress build(){
            return new LocationAddress(this);
        }
    }

    @Override
    public String toString() {
        return "LocationAddress{" +
                "postalAddress='" + postalAddress + '\'' +
                ", physicalAddress='" + physicalAddress + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationAddress)) return false;

        LocationAddress that = (LocationAddress) o;

        if (getPostalAddress() != null ? !getPostalAddress().equals(that.getPostalAddress()) : that.getPostalAddress() != null)
            return false;
        if (getPhysicalAddress() != null ? !getPhysicalAddress().equals(that.getPhysicalAddress()) : that.getPhysicalAddress() != null)
            return false;
        if (getContactNumber() != null ? !getContactNumber().equals(that.getContactNumber()) : that.getContactNumber() != null)
            return false;
        if (getPostalCode() != null ? !getPostalCode().equals(that.getPostalCode()) : that.getPostalCode() != null)
            return false;
        return !(getEmailAddress() != null ? !getEmailAddress().equals(that.getEmailAddress()) : that.getEmailAddress() != null);

    }

    @Override
    public int hashCode() {
        int result = getPostalAddress() != null ? getPostalAddress().hashCode() : 0;
        result = 31 * result + (getPhysicalAddress() != null ? getPhysicalAddress().hashCode() : 0);
        result = 31 * result + (getContactNumber() != null ? getContactNumber().hashCode() : 0);
        result = 31 * result + (getPostalCode() != null ? getPostalCode().hashCode() : 0);
        result = 31 * result + (getEmailAddress() != null ? getEmailAddress().hashCode() : 0);
        return result;
    }
}
