package hashwork.factories.payroll.ui.Job;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.PayrollTaxCalculations;

/**
 * Created by zamzam on 15/09/07.
 */
public class PayrollTaxCalculationsFactory {
    public static PayrollTaxCalculations getPayrollTaxCalculations(String taxCodesId){
        PayrollTaxCalculations payrollTaxCalculations = new PayrollTaxCalculations
                .Builder()
                .id(KeyGenerator.getEntityId())
                .taxCodesId(taxCodesId).build();
        return payrollTaxCalculations;
    }
}
