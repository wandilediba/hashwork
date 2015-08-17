package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeAllowance implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String personId;
    private String allowanceType;
    private BigDecimal amount;
    private Date validAsFrom;
}
