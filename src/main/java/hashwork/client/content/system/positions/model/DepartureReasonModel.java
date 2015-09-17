package hashwork.client.content.system.positions.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/09/16.
 */
public class DepartureReasonModel implements Serializable {

    private String reasonName;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }
}
