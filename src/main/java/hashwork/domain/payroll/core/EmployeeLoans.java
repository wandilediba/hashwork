package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeLoans implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String personId;
    private BigDecimal loanAmount;
    private BigDecimal loanInstalment;
    private BigDecimal interestRatePerMonth;
    private Date loanCommenceDate;
    private Date loanExpectedEndDate;
    private BigDecimal balance;
    private String loanType;
    private Date lastPaymentDate;
}
