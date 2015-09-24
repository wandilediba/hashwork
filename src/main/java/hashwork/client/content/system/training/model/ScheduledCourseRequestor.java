package hashwork.client.content.system.training.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class ScheduledCourseRequestor implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String scheduledCourseId;
    private String requesterId;

    public String getId() {
        return id;
    }

    public String getScheduledCourseId() {
        return scheduledCourseId;
    }

    public String getRequesterId() {
        return requesterId;
    }


    public ScheduledCourseRequestor(){}

    public void setId(String id) {
        this.id = id;
    }

    public void setScheduledCourseId(String scheduledCourseId) {
        this.scheduledCourseId = scheduledCourseId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }
}
