package hashwork.client.content.system.training.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zenzile on 2015/09/19.
 */
public class CompetencyRequestModel implements Serializable {

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

    public void setId(String id) {
        this.id = id;
    }

    public String getCompetencyName() {
        return competencyName;
    }

    public void setCompetencyName(String competencyName) {
        this.competencyName = competencyName;
    }

    public String getCompetencyId() {
        return competencyId;
    }

    public void setCompetencyId(String competencyId) {
        this.competencyId = competencyId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestorName() {
        return requestorName;
    }

    public void setRequestorName(String requestorName) {
        this.requestorName = requestorName;
    }

    public String getRequestorId() {
        return requestorId;
    }

    public void setRequestorId(String requestorId) {
        this.requestorId = requestorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRejectComment() {
        return rejectComment;
    }

    public void setRejectComment(String rejectComment) {
        this.rejectComment = rejectComment;
    }
}
