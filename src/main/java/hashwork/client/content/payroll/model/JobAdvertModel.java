package hashwork.client.content.payroll.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by zamzam on 15/09/22.
 */
public class JobAdvertModel implements Serializable {
    private String jobId;
    private Date start;
    private Date closingDate;
    private String description;
    private String active;
    private List<String> applicantsIds;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public List<String> getApplicantsIds() {
        return applicantsIds;
    }

    public void setApplicantsIds(List<String> applicantsIds) {
        this.applicantsIds = applicantsIds;
    }
}
