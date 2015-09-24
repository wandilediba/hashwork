package hashwork.app.facade;

import hashwork.services.payroll.core.*;
import hashwork.services.payroll.core.Impl.*;

/**
 * Created by nkosi on 2015/09/14.
 */

public class PayrollCoreFacade {
    public final static CompanyPayrollService companyPayrollService = new CompanyPayrollServiceImpl();
    public final static EmployeeAllowanceService employeeAllowanceService = new EmployeeAllowanceServiceImpl();
    public final static EmployeeEarningService employeeEarningService = new EmployeeEarningServiceImpl();
    public final static EmployeePayslipService employeePayslipService = new EmployeePayslipServiceImpl();
    public final static EmployeeTaxCertificateService employeeTaxCertificateService = new EmployeeTaxCertificateServiceImpl();
    public final static TaxThresholdsService taxThresholdsService = new TaxThresholdsServiceImpl();
}
