package hashwork.client.content.system.locations.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/09/07.
 */
public class RegistrationBodyModel implements Serializable {
    private String name;
    private String description;
    private String coreActivity;
    private String active;
    private Date asOfDate;

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

    public String getCoreActivity() {
        return coreActivity;
    }

    public void setCoreActivity(String coreActivity) {
        this.coreActivity = coreActivity;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Date getAsOfDate() {
        return asOfDate;
    }

    public void setAsOfDate(Date asOfDate) {
        this.asOfDate = asOfDate;
    }
}
