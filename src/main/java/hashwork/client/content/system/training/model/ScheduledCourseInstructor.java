package hashwork.client.content.system.training.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class ScheduledCourseInstructor implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String ScheduledCourseId;
    private String trainerId;

    public String getId() {
        return id;
    }

    public String getScheduledCourseId() {
        return ScheduledCourseId;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setScheduledCourseId(String scheduledCourseId) {
        ScheduledCourseId = scheduledCourseId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public ScheduledCourseInstructor(){}


}
