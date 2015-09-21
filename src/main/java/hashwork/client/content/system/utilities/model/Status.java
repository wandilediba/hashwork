package hashwork.client.content.system.utilities.model;

import java.io.Serializable;

/**
 * Created by bulelani on 2015/09/19.
 */
public class Status implements Serializable {
    private String id;
    private String statusType;
    private String statusValues;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getStatusValues() {
        return statusValues;
    }

    public void setStatusValues(String statusValues) {
        this.statusValues = statusValues;
    }
}
