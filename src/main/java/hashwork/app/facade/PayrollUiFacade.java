package hashwork.app.facade;

import hashwork.services.payroll.ui.EarningListService;
import hashwork.services.payroll.ui.Impl.EarningListServiceImpl;

/**
 * Created by nkosi on 2015/09/21.
 */
public class PayrollUiFacade {
    public final static EarningListService EarningListService = new EarningListServiceImpl();
}
