package hashwork.factories.payroll.ui;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.LoansList;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by nkosi on 2015/09/01.
 */

public class LoanListFactory {
    public static LoansList getLoansList(Map<String, String> stringValues,
                                         Map<String, BigDecimal> bigDecimalValues,
                                         int loanPaybackPeriod) {
        LoansList loansList = new LoansList
                .Builder()
                .id(KeyGenerator.getEntityId())
                .loanDesc(stringValues.get("loanDesc"))
                .loanType(stringValues.get("loanType"))
                .loanPaybackPeriod(loanPaybackPeriod)
                .maxLoanAmt(bigDecimalValues.get("maxLoanAmt"))
                .standardInterest(bigDecimalValues.get("standardInterest"))
                .build();
        return loansList;
    }
}