package hashwork.client.content.system.training.model;

import java.io.Serializable;
import java.util.*;

/**
 * Created by hashcode on 2015/08/16.
 */
public class ScheduledCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private int courseCapacity;
    private int numOfStuds;
    private Date startDate;
    private Date endDate;
    private Date dateRequested;
    private String courseNameId;
    private String venue;
    private String status;
    private List<String> courseRequestors = new ArrayList<>();
    private List<String> courseFundersIds = new ArrayList<>();
    private Set<String> participants = new HashSet<>();

    public ScheduledCourse(){}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public int getNumOfStuds() {
        return numOfStuds;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public String getCourseNameId() {
        return courseNameId;
    }

    public String getVenue() {
        return venue;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getCourseRequestors() {
        return courseRequestors;
    }

    public List<String> getCourseFundersIds() {
        return courseFundersIds;
    }

    public Set<String> getParticipants() {
        return participants;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public void setNumOfStuds(int numOfStuds) {
        this.numOfStuds = numOfStuds;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    public void setCourseNameId(String courseNameId) {
        this.courseNameId = courseNameId;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCourseRequestors(List<String> courseRequestors) {
        this.courseRequestors = courseRequestors;
    }

    public void setCourseFundersIds(List<String> courseFundersIds) {
        this.courseFundersIds = courseFundersIds;
    }

    public void setParticipants(Set<String> participants) {
        this.participants = participants;
    }
}
