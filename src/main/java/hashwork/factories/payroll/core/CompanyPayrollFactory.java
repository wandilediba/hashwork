package hashwork.factories.payroll.core;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.core.CompanyPayroll;

import java.util.Date;
import java.util.Map;

/**
 * Created by nkosi on 2015/09/02.
 */


public class CompanyPayrollFactory {
    public static CompanyPayroll getCompanyPayroll(Map<String, String> values,
                                                   Date payPeriod) {
        CompanyPayroll companyPayroll = new CompanyPayroll
                .Builder()
                .id(KeyGenerator.getEntityId())
                .companyId(values.get("companyId"))
                .employeeType("employeeType")
                .payPeriod(payPeriod)
                .build();
        return companyPayroll;
    }
}
