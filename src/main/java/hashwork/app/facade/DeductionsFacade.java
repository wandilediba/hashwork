package hashwork.app.facade;

import hashwork.services.payroll.core.deductions.*;
import hashwork.services.payroll.core.deductions.Impl.*;
import hashwork.services.payroll.ui.deductions.*;
import hashwork.services.payroll.ui.deductions.Impl.*;

/**
 * Created by kurt on 2015/14/09.
 */
public class DeductionsFacade {
    //core
    public final static EmployeeDeductionsService employeeDeductionsService = new EmployeeDeductionsServicesImpl();
    public final static EmployeeLeaveDataService employeeLeaveDataService = new EmployeeLeaveDataServiceImpl();
    public final static EmployeeMedicalAidService employeeMedicalAidService = new EmployeeMedicalAidServiceImpl();
    public final static EmployeePensionService employeePensionService = new EmployeePensionServiceImpl();
    public final static EmployeeUIFContributionService employeeUIFContributionService = new EmployeeUIFContributionServiceImpl();
    
    //ui
    public final static AllowanceTypeListService allowanceTypeListService = new AllowanceTypeListServiceImpl();
    public final static LeaveTypeListService leaveTypeListService = new LeaveTypeListServiceImpl();
    public final static MedicalAidListService medicalAidListService = new MedicalAidListServiceImpl();
    public final static PensionFundService pensionFundService = new PensionFundServiceImpl();
    public final static UIFContributionListService uifContributionListService = new UIFContributionListServiceImpl();    
    
}
