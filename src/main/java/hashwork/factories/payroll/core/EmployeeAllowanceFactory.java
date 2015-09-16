package hashwork.factories.payroll.core;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.core.EmployeeAllowance;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Created by nkosi on 2015/09/02.
 */

public class EmployeeAllowanceFactory {
    public static EmployeeAllowance getEmployeeAllowance(Map<String, String> values,
                                                         BigDecimal amount, Date validAsFrom) {
        EmployeeAllowance employeeAllowance = new EmployeeAllowance
                .Builder()
                .id(KeyGenerator.getEntityId())
                .personId(values.get("personId"))
                .allowanceType("allowanceType")
                .amount(amount)
                .validAsFrom(validAsFrom)
                .build();
        return employeeAllowance;
    }
}
