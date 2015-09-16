package hashwork.factories.payroll.core;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.core.EmployeeEarnings;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Created by nkosi on 2015/09/02.
 */

public class EmployeeEarningsFactory {
    public static EmployeeEarnings getEmployeeEarnings(String personId, BigDecimal earningsAmt,
                                                       Map<String, String> values, Date payDate) {
        EmployeeEarnings taxCodes = new EmployeeEarnings
                .Builder()
                .id(KeyGenerator.getEntityId())
                .personId(personId)
                .earningsAmt(earningsAmt)
                .earningsTypeDesc(values.get("earningsTypeDesc"))
                .earningsCode("earningsCode")
                .payDate(payDate)
                .build();
        return taxCodes;
    }
}
