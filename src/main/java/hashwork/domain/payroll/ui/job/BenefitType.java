package hashwork.domain.payroll.ui.job;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/16.
 */
public class BenefitType implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    //Allowance, Travel Advance and Bonus.
    private String benefitTypeName;
    private BigDecimal amount;
    private String  currencyId;
}
