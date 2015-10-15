package hashwork.client.content.training.institutions.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/10/08.
 */
public class ScheduledCourseModel implements Serializable {
    private int courseCapacity;
    private Date startDate;
    private Date endDate;
    private Date dateRequested;
    private String courseNameId;
    private String venue;
    private String status;

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getCourseNameId() {
        return courseNameId;
    }

    public void setCourseNameId(String courseNameId) {
        this.courseNameId = courseNameId;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
