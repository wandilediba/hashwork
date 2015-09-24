package hashwork.client.content.system.training.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by hashcode on 2015/08/16.
 */
public class CourseRequest implements Serializable {

    private String id;
    private String requestName;

    private List<String> requestorsIds; //People Who requested Course

    private List<String> competenciesIds;
    private Date prefferedStart;
    private Date preferredEnd;
    private Date requestedDate;
    private List<String> funderIds;
    private List<String> trainingInstitutionsId;
    private String status;


    public void setId(String id) {
        this.id = id;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public void setRequestorsIds(List<String> requestorsIds) {
        this.requestorsIds = requestorsIds;
    }

    public void setCompetenciesIds(List<String> competenciesIds) {
        this.competenciesIds = competenciesIds;
    }

    public void setPrefferedStart(Date prefferedStart) {
        this.prefferedStart = prefferedStart;
    }

    public void setPreferredEnd(Date preferredEnd) {
        this.preferredEnd = preferredEnd;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public void setFunderIds(List<String> funderIds) {
        this.funderIds = funderIds;
    }

    public void setTrainingInstitutionsId(List<String> trainingInstitutionsId) {
        this.trainingInstitutionsId = trainingInstitutionsId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getRequestName() {
        return requestName;
    }

    public List<String> getRequestorsIds() {
        return requestorsIds;
    }

    public List<String> getCompetenciesIds() {
        return competenciesIds;
    }

    public Date getPrefferedStart() {
        return prefferedStart;
    }

    public Date getPreferredEnd() {
        return preferredEnd;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public List<String> getFunderIds() {
        return funderIds;
    }

    public List<String> getTrainingInstitutionsId() {
        return trainingInstitutionsId;
    }

    public String getStatus() {
        return status;
    }

    private CourseRequest(){}


}
