package hashwork.domain.payroll.core.deductions;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeDeductions implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String personId;
    private BigDecimal deductionAmt;
    private String deductionTypeDesc;

}
