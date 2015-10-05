package hashwork.app.facade;

import hashwork.services.payroll.core.deductions.*;
import hashwork.services.payroll.core.deductions.Impl.*;

/**
 * Created by zamzam on 2015/10/03.
 */
public class PayrollCoreDeductionsFacade {
    public final static EmployeeDeductionsService employeeDeductionsServices = new EmployeeDeductionsServicesImpl();
    public final static EmployeeLeaveDataService employeeLeaveDataService = new EmployeeLeaveDataServiceImpl();
    public final static EmployeeMedicalAidService employeeMedicalAidService = new EmployeeMedicalAidServiceImpl();
    public final static EmployeePensionService employeePensionService = new EmployeePensionServiceImpl();
    public final static EmployeeUIFContributionService employeeUIFContributionService = new EmployeeUIFContributionServiceImpl();
}
