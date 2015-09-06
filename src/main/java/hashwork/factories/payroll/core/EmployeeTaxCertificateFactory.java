package hashwork.factories.payroll.core;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.core.EmployeeTaxCertificate;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by nkosi on 2015/09/03.
 */

public class EmployeeTaxCertificateFactory {
    public static EmployeeTaxCertificate getEmployeeTaxCertificate(Map<String, String> stringValues,
                                                                   Map<String, String> stringValues2,
                                                                   BigDecimal employeeTaxAmt) {
        EmployeeTaxCertificate employeeTaxCertificate = new EmployeeTaxCertificate
                .Builder()
                .id(KeyGenerator.getEntityId())
                .personId(stringValues.get("personID"))
                .employer(stringValues.get("employer"))
                .uifNumber(stringValues2.get("uifNumber"))
                .taxReferenceNumber(stringValues2.get("taxReferenceNumber"))
                .employeeTaxAmt(employeeTaxAmt)
                .build();
        return employeeTaxCertificate;
    }
}
