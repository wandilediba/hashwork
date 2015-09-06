package hashwork.domain.payroll.ui.job;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by hashcode on 2015/08/16.
 */
public class JobAdvert implements Serializable {
    private static final long serialVersionUID = 1L;

    private String Id;
    private String jobId;
    private Date start;
    private Date closingDate;
    private String description;
    private String active;
    private List<String> applicantsIds;

    public String getId() {
        return Id;
    }

    public String getJobId() {
        return jobId;
    }

    public Date getStart() {
        return start;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public String getDescription() {
        return description;
    }

    public String getActive() {
        return active;
    }

    public List<String> getApplicantsIds() {
        return applicantsIds;
    }
}
