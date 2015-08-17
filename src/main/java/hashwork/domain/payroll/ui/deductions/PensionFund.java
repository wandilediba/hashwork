package hashwork.domain.payroll.ui.deductions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PensionFund implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String pensionCode;
    private String description;
    private BigDecimal percentage;
    private Date percentageAsOfDate;
}
