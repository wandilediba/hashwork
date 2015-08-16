package hashwork.domain.ui.job;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/16.
 */
public class SalaryGrade implements Serializable {

    private static long serialVersionUID = 1L;
    private String id;
    private String gradeName;
    private String notes;
    private BigDecimal midAmount;
    private BigDecimal endAmount;
    private BigDecimal startAmount;
    private BigDecimal currentAmount;
    private String currencyId;
}
