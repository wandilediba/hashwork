package hashwork.domain.payroll.ui.job;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by hashcode on 2015/08/16.
 */
public class JobAdvert implements Serializable {

    private String Id;
    private String jobId;
    private Date start;
    private Date closingDate;
    private String description;
    private String active;
    private List<String> applicantsIds;
}
