package hashwork.domain.ui.contactdetails;

import java.io.Serializable;

/**
 * Created by garran on 2015/08/31.
 */
public class MobileNumber implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String mobileNumber;

    public String getId() {
        return id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    private MobileNumber() {
    }

    private MobileNumber(Builder builder) {
        this.id = builder.id;
        this.mobileNumber = builder.mobileNumber;
    }

    public static class Builder {
        private String id;
        private String mobileNumber;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder mobileNumber(String value) {
            this.mobileNumber = value;
            return this;
        }

        public Builder copy(MobileNumber value) {
            this.id = value.id;
            this.mobileNumber = value.mobileNumber;
            return this;
        }

        public MobileNumber build() {
            return new MobileNumber(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MobileNumber)) return false;

        MobileNumber that = (MobileNumber) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return !(getMobileNumber() != null ? !getMobileNumber().equals(that.getMobileNumber()) : that.getMobileNumber() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getMobileNumber() != null ? getMobileNumber().hashCode() : 0);
        return result;
    }
}