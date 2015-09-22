package hashwork.client.content.system.office.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by garran on 2015/09/20.
 */
public class OfficeModel implements Serializable {
    private String name;
    private String description;
    private String active;
    private Date dateEstablished;
    private String officeTypeId;
    private String cityId;
    private String contactId;
    private Set<String> positionIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Date getDateEstablished() {
        return dateEstablished;
    }

    public void setDateEstablished(Date dateEstablished) {
        this.dateEstablished = dateEstablished;
    }

    public String getOfficeTypeId() {
        return officeTypeId;
    }

    public void setOfficeTypeId(String officeTypeId) {
        this.officeTypeId = officeTypeId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public Set<String> getPositionIds() {
        return positionIds;
    }

    public void setPositionIds(Set<String> positionIds) {
        this.positionIds = positionIds;
    }
}
