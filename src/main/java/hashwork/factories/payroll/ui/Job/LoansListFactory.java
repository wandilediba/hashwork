package hashwork.factories.payroll.ui.Job;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.LoansList;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by zamzam on 15/09/07.
 */
public class LoansListFactory {
    public static LoansList getLoansList(Map<String,String> values,
                                         int loanPaybackPeriod,
                                         Map<String, BigDecimal> amounts){
        LoansList loansList = new LoansList
                .Builder()
                .id(KeyGenerator.getEntityId())
                .loanType(values.get("loanType"))
                .loanDesc(values.get("loanDesc"))
                .loanPaybackPeriod(loanPaybackPeriod)
                .maxLoanAmt(amounts.get("maxLoanAmt"))
                .standardInterest(amounts.get("stdInterest")).build();
        return loansList;
    }
}
