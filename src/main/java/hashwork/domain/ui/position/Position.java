package hashwork.domain.ui.position;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Position implements Serializable, Comparable<Position> {
    private static long serialVersionUID = 1L;
    private String id;
    private String positionCode;

    private String positionTitle;
    private String description;
    private Date postionEntryDate;
    private Date positionEndDate;
    private String currentOccupantId;

    private String positionTypeId;

    private String positionStatusId;
    private String positionComments;

    private String officeId;
    private List<String> subodinateIds = new ArrayList<String>();

    private String supervisorId; // PositionId

    private String departmentId;

    private String jobId;


    @Override
    public int compareTo(Position o) {
        return positionTitle.compareTo(o.positionTitle);
    }

    public Position(){}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public String getDescription() {
        return description;
    }

    public Date getPostionEntryDate() {
        return postionEntryDate;
    }

    public Date getPositionEndDate() {
        return positionEndDate;
    }

    public String getCurrentOccupantId() {
        return currentOccupantId;
    }

    public String getPositionTypeId() {
        return positionTypeId;
    }

    public String getPositionStatusId() {
        return positionStatusId;
    }

    public String getPositionComments() {
        return positionComments;
    }

    public String getOfficeId() {
        return officeId;
    }

    public List<String> getSubodinateIds() {
        return subodinateIds;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getJobId() {
        return jobId;
    }

    private Position(Builder builder) {
        this.id = builder.id;
        this.positionCode = builder.positionCode;
        this.positionTitle = builder.positionTitle;
        this.description = builder.description;
        this.postionEntryDate = builder.postionEntryDate;
        this.positionEndDate = builder.positionEndDate;
        this.currentOccupantId = builder.currentOccupantId;
        this.positionTypeId = builder.positionTypeId;
        this.positionStatusId = builder.positionStatusId;
        this.positionComments = builder.positionComments;
        this.officeId = builder.officeId;
        this.subodinateIds = builder.subodinateIds;
        this.supervisorId = builder.supervisorId;
        this.departmentId = builder.departmentId;
        this.jobId = builder.jobId;
    }

    public static class Builder {
        private String id;
        private String positionCode;
        private String positionTitle;
        private String description;
        private Date postionEntryDate;
        private Date positionEndDate;
        private String currentOccupantId;
        private String positionTypeId;
        private String positionStatusId;
        private String positionComments;
        private String officeId;
        private List<String> subodinateIds = new ArrayList<String>();
        private String supervisorId; // PositionId
        private String departmentId;
        private String jobId;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder positionCode(String value) {
            this.positionCode = value;
            return this;
        }

        public Builder positionTitle(String value) {
            this.positionTitle = value;
            return this;
        }

        public Builder description(String value) {
            this.description = value;
            return this;
        }

        public Builder postionEntryDate(Date value) {
            this.postionEntryDate = value;
            return this;
        }

        public Builder positionEndDate(Date value) {
            this.positionEndDate = value;
            return this;
        }

        public Builder currentOccupantId(String value) {
            this.currentOccupantId = value;
            return this;
        }

        public Builder positionTypeId(String value) {
            this.positionTypeId = value;
            return this;
        }

        public Builder positionStatusId(String value) {
            this.positionStatusId = value;
            return this;
        }

        public Builder positionComments(String value) {
            this.positionComments = value;
            return this;
        }

        public Builder officeId(String value) {
            this.officeId = value;
            return this;
        }

        public Builder subodinateIds(List<String> value) {
            this.subodinateIds = value;
            return this;
        }

        public Builder supervisorId(String value) {
            this.supervisorId = value;
            return this;
        }

        public Builder departmentId(String value) {
            this.departmentId = value;
            return this;
        }

        public Builder jobId(String value) {
            this.jobId = value;
            return this;
        }

        public Builder copy(Position value) {
            this.id = value.id;
            this.positionCode = value.positionCode;
            this.positionTitle = value.positionTitle;
            this.description = value.description;
            this.postionEntryDate = value.postionEntryDate;
            this.positionEndDate = value.positionEndDate;
            this.currentOccupantId = value.currentOccupantId;
            this.positionTypeId = value.positionTypeId;
            this.positionStatusId = value.positionStatusId;
            this.positionComments = value.positionComments;
            this.officeId = value.officeId;
            this.subodinateIds = value.subodinateIds;
            this.supervisorId = value.supervisorId;
            this.departmentId = value.departmentId;
            this.jobId = value.jobId;
            return this;
        }

        public Position build(){
            return new Position(this);
        }
    }

}
