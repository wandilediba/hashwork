package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class CompanyPayroll implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String companyId;
    private Date payPeriod;
    private String employeeType;
}
