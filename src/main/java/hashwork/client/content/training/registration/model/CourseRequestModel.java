package hashwork.client.content.training.registration.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by hashcode on 2015/10/08.
 */
public class CourseRequestModel implements Serializable {

    private String requestName;
    private List<String> requestors;
    private List<String> competencies;
    private Date prefferedStart;
    private Date preferredEnd;
    private List<String> funder;
    private String status;
    private List<String> trainingInstitutions;

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public List<String> getRequestors() {
        return requestors;
    }

    public void setRequestors(List<String> requestors) {
        this.requestors = requestors;
    }

    public List<String> getCompetencies() {
        return competencies;
    }

    public void setCompetencies(List<String> competencies) {
        this.competencies = competencies;
    }

    public Date getPrefferedStart() {
        return prefferedStart;
    }

    public void setPrefferedStart(Date prefferedStart) {
        this.prefferedStart = prefferedStart;
    }

    public Date getPreferredEnd() {
        return preferredEnd;
    }

    public void setPreferredEnd(Date preferredEnd) {
        this.preferredEnd = preferredEnd;
    }

    public List<String> getFunder() {
        return funder;
    }

    public void setFunder(List<String> funder) {
        this.funder = funder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getTrainingInstitutions() {
        return trainingInstitutions;
    }

    public void setTrainingInstitutions(List<String> trainingInstitutions) {
        this.trainingInstitutions = trainingInstitutions;
    }
}
