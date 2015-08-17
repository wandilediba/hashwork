package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeTaxCertificate implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String personId;
    private String employer;
    private String taxReferenceNumber;
    private String uifNumber;
    private BigDecimal employeeTaxAmt;
}
