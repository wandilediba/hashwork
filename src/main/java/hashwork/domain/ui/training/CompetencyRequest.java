package hashwork.domain.ui.training;

import hashwork.domain.ui.education.Competency;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/16.
 */
public class CompetencyRequest implements Serializable {

    private String id;
    private String competencyName;
    private String competencyId;
    private Date requestDate;
    private String requestorName;
    private String requestorId;
    //PENDING, APPROVED, REJECTED,FULLFILEED
    private String status;
    private String rejectComment;


    public String getId() {
        return id;
    }

    public String getCompetencyName() {
        return competencyName;
    }

    public String getCompetencyId() {
        return competencyId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public String getRequestorName() {
        return requestorName;
    }

    public String getRequestorId() {
        return requestorId;
    }

    public String getStatus() {
        return status;
    }

    private CompetencyRequest(Builder builder) {
        this.id = builder.id;
        this.competencyName = builder.competencyName;
        this.competencyId = builder.competencyId;
        this.requestDate = builder.requestDate;
        this.requestorName = builder.requestorName;
        this.requestorId = builder.requestorId;
        this.status = builder.status;
        this.rejectComment = builder.rejectComment;

    }

    public String getRejectComment() {
        return rejectComment;
    }

    public static class Builder {
        private String id;
        private String competencyName;
        private String competencyId;
        private Date requestDate;
        private String requestorName;
        private String requestorId;
        private String status;
        private String rejectComment;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder competencyName(String value) {
            this.competencyName = value;
            return this;
        }

        public Builder competencyId(String value) {
            this.competencyId = value;
            return this;
        }

        public Builder requestDate(Date value) {
            this.requestDate = value;
            return this;
        }

        public Builder requestorName(String value) {
            this.requestorName = value;
            return this;
        }

        public Builder requestorId(String value) {
            this.requestorId = value;
            return this;
        }

        public Builder status(String value) {
            this.status = value;
            return this;
        }

        public Builder rejectComment(String value) {
            this.rejectComment = value;
            return this;
        }

        public Builder copy(CompetencyRequest value) {
            this.id = value.id;
            this.competencyName = value.competencyName;
            this.competencyId = value.competencyId;
            this.requestDate = value.requestDate;
            this.requestorName = value.requestorName;
            this.requestorId = value.requestorId;
            this.status = value.status;
            this.rejectComment = value.rejectComment;

            return this;

        }

        public CompetencyRequest build() {
            return new CompetencyRequest(this);
        }
    }
}
