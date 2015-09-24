package hashwork.client.content.system.positions.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/09/16.
 */
public class PositionModel implements Serializable {

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
    private String supervisorId; // PositionId

    private String departmentId;

    private String jobId;

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPostionEntryDate() {
        return postionEntryDate;
    }

    public void setPostionEntryDate(Date postionEntryDate) {
        this.postionEntryDate = postionEntryDate;
    }

    public Date getPositionEndDate() {
        return positionEndDate;
    }

    public void setPositionEndDate(Date positionEndDate) {
        this.positionEndDate = positionEndDate;
    }

    public String getCurrentOccupantId() {
        return currentOccupantId;
    }

    public void setCurrentOccupantId(String currentOccupantId) {
        this.currentOccupantId = currentOccupantId;
    }

    public String getPositionTypeId() {
        return positionTypeId;
    }

    public void setPositionTypeId(String positionTypeId) {
        this.positionTypeId = positionTypeId;
    }

    public String getPositionStatusId() {
        return positionStatusId;
    }

    public void setPositionStatusId(String positionStatusId) {
        this.positionStatusId = positionStatusId;
    }

    public String getPositionComments() {
        return positionComments;
    }

    public void setPositionComments(String positionComments) {
        this.positionComments = positionComments;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
