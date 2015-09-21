package hashwork.app.facade;

import hashwork.services.payroll.ui.deductions.*;
import hashwork.services.payroll.ui.deductions.Impl.*;

/**
 * Created by nkosi on 2015/09/16.
 */
public class PayrollUiDeductionsFacade {
    public final static AllowanceTypeListService allowanceTypeListService = new AllowanceTypeListServiceImpl();
    public final static LeaveTypeListService leaveTypeListService = new LeaveTypeListServiceImpl();
    public final static MedicalAidListService medicalAidListService = new MedicalAidListServiceImpl();
    public final static PensionFundService pensionFundService = new PensionFundServiceImpl();
    public final static UIFContributionListService uIFContributionListService =  new UIFContributionListServiceImpl();
}
