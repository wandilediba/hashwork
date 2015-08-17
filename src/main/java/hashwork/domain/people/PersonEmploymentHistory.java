package hashwork.domain.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PersonEmploymentHistory implements Serializable {
    private String id;
    private String personId;
    private String companyName;
    private String companyAddress;
    private String companyTelephone;
    private String applicatSupervisor;
    private Boolean contactSupervisor;
    private String reasonsForLeaving;
    private Date startDate;
    private Date endDate;
    private BigDecimal startingSalary;
    private BigDecimal endingSalary;
    private String currencyId;
    private String jobResponsibility;
    private String jobId;

}
