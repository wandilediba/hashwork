package hashwork.client.content.system.positions.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/09/16.
 */
public class PositionLifeCycleModel implements Serializable {

    private String positionId;
    private Date dateofAction;
    private String status;

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public Date getDateofAction() {
        return dateofAction;
    }

    public void setDateofAction(Date dateofAction) {
        this.dateofAction = dateofAction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
