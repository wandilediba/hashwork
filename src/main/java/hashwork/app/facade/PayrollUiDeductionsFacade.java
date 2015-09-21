package hashwork.app.facade;

import hashwork.services.payroll.ui.deductions.AllowanceTypeListService;
import hashwork.services.payroll.ui.deductions.Impl.AllowanceTypeListServiceImpl;

/**
 * Created by nkosi on 2015/09/16.
 */
public class PayrollUiDeductionsFacade {
    public final static AllowanceTypeListService allowanceTypeListService = new AllowanceTypeListServiceImpl();

}
