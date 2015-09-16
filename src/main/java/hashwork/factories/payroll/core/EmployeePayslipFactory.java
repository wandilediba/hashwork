package hashwork.factories.payroll.core;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.core.EmployeePayslip;

import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by nkosi on 2015/09/14.
 */

public class EmployeePayslipFactory {
    public static EmployeePayslip getEmployeePayslip(String personID, BigDecimal netpay,
                                                     Date payslipGenerateDate) {
        EmployeePayslip employeePayslip = new EmployeePayslip
                .Builder()
                .id(KeyGenerator.getEntityId())
                .personId(personID)
                .netPay(netpay )
                .payslipGenerateDate(payslipGenerateDate)
                .build();
        return employeePayslip;
    }
}
