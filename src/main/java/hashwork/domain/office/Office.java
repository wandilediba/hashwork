package hashwork.domain.office;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author BONGANI
 */
public class Office implements Serializable{
    private String id;
    private String name;
    private String description;
    private String active;
    private Date dateEstablished;
    private String officeTypeId;
    private String cityId;
    private String contactId;
    private List<String> positionIds;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getActive() {
        return active;
    }

    public Date getDateEstablished() {
        return dateEstablished;
    }

    public String getOfficeTypeId() {
        return officeTypeId;
    }

    public String getCityId() {
        return cityId;
    }

    public String getContactId() {
        return contactId;
    }

    public List<String> getPositionIds() {
        return positionIds;
    }

    public void setPositionIds(List<String> positionIds) {
        this.positionIds = positionIds;
    }

    private Office() {
    }

    private Office(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.active = builder.active;
        this.dateEstablished = builder.dateEstablished;
        this.officeTypeId = builder.officeTypeId;
        this.cityId = builder.cityId;
        this.contactId = builder.contactId;
        this.positionIds = builder.positionIds;

    }

    public static class Builder {
        private String id;
        private String name;
        private String description;
        private String active;
        private Date dateEstablished;
        private String officeTypeId;
        private String cityId;
        private String contactId;
        private List<String> positionIds;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder description(String value) {
            this.description = value;
            return this;
        }

        public Builder active(String value) {
            this.active = value;
            return this;
        }

        public Builder officeTypeId(String value) {
            this.officeTypeId = value;
            return this;
        }

        public Builder dateEstablished(Date date) {
            this.dateEstablished = date;
            return this;
        }

        public Builder cityId(String value) {
            this.cityId = value;
            return this;
        }

        public Builder contactId(String value) {
            this.contactId = value;
            return this;
        }

        public Builder positionIds(List<String> value) {
            this.positionIds = value;
            return this;
        }

        public Builder copy(Office value) {
            this.id = value.id;
            this.name = value.name;
            this.description = value.description;
            this.active = value.active;
            this.dateEstablished = value.dateEstablished;
            this.officeTypeId = value.officeTypeId;
            this.cityId = value.cityId;
            this.contactId = value.contactId;
            this.positionIds = value.positionIds;
            return this;
        }

        public Office build() {
            return new Office(this);
        }
    }
}
