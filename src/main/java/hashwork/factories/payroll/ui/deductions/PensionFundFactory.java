package hashwork.factories.payroll.ui.deductions;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.deductions.PensionFund;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Created by zamzam on 15/09/05.
 */
public class PensionFundFactory {
    public static PensionFund getPensionFund(Map<String, String> values,
                                             BigDecimal percentage,
                                             Date percentageAsOfDate) {
        PensionFund pensionFund = new PensionFund
                .Builder()
                .id(KeyGenerator.getEntityId())
                .pensionCode(values.get("pensionCode"))
                .description(values.get("description"))
                .percentage(percentage)
                .percentageAsOfDate(percentageAsOfDate).build();
        return pensionFund;
    }
}
