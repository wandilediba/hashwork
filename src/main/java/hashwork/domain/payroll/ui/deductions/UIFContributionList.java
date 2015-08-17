package hashwork.domain.payroll.ui.deductions;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class UIFContributionList implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String code;
    private BigDecimal uifPercentContribution;
}
