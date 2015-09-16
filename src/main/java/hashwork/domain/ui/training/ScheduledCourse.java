package hashwork.domain.ui.training;

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

    private ScheduledCourse(){}

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

    private ScheduledCourse(Builder builder) {
        this.id = builder.id;
        this.courseCapacity = builder.courseCapacity;
        this.numOfStuds = builder.numOfStuds;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.dateRequested = builder.dateRequested;
        this.venue = builder.venue;
        this.status = builder.status;
        this.courseRequestors = builder.courseRequestors;
        this.courseFundersIds = builder.courseFundersIds;
        this.participants = builder.participants;
    }

    public static class Builder {
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

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder courseCapacity(int value) {
            this.courseCapacity = value;
            return this;
        }

        public Builder numOfStuds(int value) {
            this.numOfStuds = value;
            return this;
        }

        public Builder startDate(Date value) {
            this.startDate = value;
            return this;
        }

        public Builder endDate(Date value) {
            this.endDate = value;
            return this;
        }

        public Builder dateRequested(Date value) {
            this.dateRequested = value;
            return this;
        }

        public Builder courseNameId(String value) {
            this.courseNameId = value;
            return this;
        }

        public Builder venue(String value) {
            this.venue = value;
            return this;
        }

        public Builder status(String value) {
            this.status = value;
            return this;
        }

        public Builder courseRequestors(List<String> value) {
            this.courseRequestors = value;
            return this;
        }

        public Builder courseFundersIds(List<String> value) {
            this.courseFundersIds = value;
            return this;
        }

        public Builder participants(Set<String> value) {
            this.participants = value;
            return this;
        }

        public Builder copy(ScheduledCourse value) {
            this.id = value.id;
            this.courseCapacity = value.courseCapacity;
            this.numOfStuds = value.numOfStuds;
            this.startDate = value.startDate;
            this.endDate = value.endDate;
            this.dateRequested = value.dateRequested;
            this.venue = value.venue;
            this.status = value.status;
            this.courseRequestors = value.courseRequestors;
            this.courseFundersIds = value.courseFundersIds;
            this.participants = value.participants;
            return this;
        }

        public ScheduledCourse build() {
            return new ScheduledCourse(this);
        }


    }
}
