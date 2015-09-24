package hashwork.client.content.system.training.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class ScheduledCourseEvaluation implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String scheduledCourseId;
    private int  rating ;
    private String comments;

    public void setId(String id) {
        this.id = id;
    }

    public void setScheduledCourseId(String scheduledCourseId) {
        this.scheduledCourseId = scheduledCourseId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public String getScheduledCourseId() {
        return scheduledCourseId;
    }

    public int getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }


    public ScheduledCourseEvaluation(){}


}
