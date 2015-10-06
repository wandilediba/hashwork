package hashwork.app.facade;

import hashwork.services.payroll.ui.EarningListService;
import hashwork.services.payroll.ui.Impl.EarningListServiceImpl;
import hashwork.services.payroll.ui.Impl.LoansListServiceImpl;
import hashwork.services.payroll.ui.Impl.PayrollTaxCalculationsServiceImpl;
import hashwork.services.payroll.ui.Impl.TaxCodesServiceImpl;
import hashwork.services.payroll.ui.LoansListService;
import hashwork.services.payroll.ui.PayrollTaxCalculationsService;
import hashwork.services.payroll.ui.TaxCodesService;

/**
 * Created by nkosi on 2015/09/21.
 */
public class PayrollUiFacade {
    public final static EarningListService earningListService = new EarningListServiceImpl();
    public final static LoansListService loansListService = new LoansListServiceImpl();
    public final static PayrollTaxCalculationsService payrollTaxCalculationsService = new PayrollTaxCalculationsServiceImpl();
    public final static TaxCodesService taxCodesService = new TaxCodesServiceImpl();
}
