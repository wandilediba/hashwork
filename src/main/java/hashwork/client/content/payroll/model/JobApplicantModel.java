package hashwork.client.content.payroll.model;

import java.io.Serializable;

/**
 * Created by zamzam on 15/09/21.
 */
public class JobApplicantModel implements Serializable {

    private String applicantId;

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }
}
