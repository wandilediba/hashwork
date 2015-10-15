package hashwork.client.content.training.employee.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/10/08.
 */
public class RequestCompetenciesModel implements Serializable {
    private String competencyName;
    private String competencyId;
    private String numberOfRequets;
    private String status;

    public String getCompetencyName() {
        return competencyName;
    }

    public void setCompetencyName(String competencyName) {
        this.competencyName = competencyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumberOfRequets() {
        return numberOfRequets;
    }

    public void setNumberOfRequets(String numberOfRequets) {
        this.numberOfRequets = numberOfRequets;
    }

    public String getCompetencyId() {
        return competencyId;
    }

    public void setCompetencyId(String competencyId) {
        this.competencyId = competencyId;
    }
}
