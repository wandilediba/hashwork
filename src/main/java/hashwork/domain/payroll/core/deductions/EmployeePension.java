package hashwork.domain.payroll.core.deductions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeePension implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String personId;
    private Date startDate;
    private String pensionCode;
    private BigDecimal goalAmount;
    private BigDecimal lastContribution;
    private Date lastContributionDate;
    private BigDecimal contributionToDate;
}
