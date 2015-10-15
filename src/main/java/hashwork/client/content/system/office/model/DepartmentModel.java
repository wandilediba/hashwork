package hashwork.client.content.system.office.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by garran on 2015/09/20.
 */
public class DepartmentModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private boolean active;
    private Date dateEstablished;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDateEstablished() {
        return dateEstablished;
    }

    public void setDateEstablished(Date dateEstablished) {
        this.dateEstablished = dateEstablished;
    }
}
