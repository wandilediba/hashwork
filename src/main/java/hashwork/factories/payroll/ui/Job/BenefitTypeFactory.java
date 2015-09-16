package hashwork.factories.payroll.ui.Job;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.job.BenefitType;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by zamzam on 15/09/06.
 */
public class BenefitTypeFactory {
    public static BenefitType getBenefitType(Map<String,String> values,
                                             BigDecimal amount){
        BenefitType benefitType = new BenefitType
                .Builder()
                .id(KeyGenerator.getEntityId())
                .benefitTypeName(values.get("benefitTypeName"))
                .amount(amount)
                .currencyId(values.get("currencyId")).build();
        return benefitType;
    }
}
