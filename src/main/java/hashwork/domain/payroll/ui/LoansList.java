package hashwork.domain.payroll.ui;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class LoansList implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String loanType;
    private String loanDesc;
    private int loanPaybackPeriod;
    private BigDecimal maxLoanAmt;
    private BigDecimal standardInterest;
}
