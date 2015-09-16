package hashwork.factories.payroll.ui;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.PayrollTaxCalculations;

/**
 * Created by nkosi on 2015/09/01.
 */
public class PayrollTaxCalculationsFactory {
    public static PayrollTaxCalculations getPayrollTaxCalculations(String taxCodesId) {
        PayrollTaxCalculations payrollTaxCalculations = new PayrollTaxCalculations
                .Builder()
                .id(KeyGenerator.getEntityId())
                .taxCodesId(taxCodesId)
                .build();
        return payrollTaxCalculations;
    }
}
