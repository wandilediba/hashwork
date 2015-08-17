package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class TaxThresholds implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String personId;
    private BigDecimal taxThreshAmt1;
    private BigDecimal taxThreshAmt2;
    private String taxThreshCategory;
    private String taxThreshDesc;
    private BigDecimal taxPercentage;
}
