package hashwork.factories.payroll.core;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.core.TaxThresholds;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by nkosi on 2015/09/02.
 */


public class TaxThresholdsFactory {
    public static TaxThresholds getTaxThresholds(String personId,
                                                 Map<String, BigDecimal> bigDecimalValues,
                                                 Map<String, String> stringValues,
                                                 BigDecimal taxPercentage) {
        TaxThresholds taxThresholds = new TaxThresholds
                .Builder()
                .id(KeyGenerator.getEntityId())
                .personId(personId)
                .taxThreshAmt1(bigDecimalValues.get("taxThreshAmt1"))
                .taxThreshAmt2(bigDecimalValues.get("taxThreshAmt2"))
                .taxThreshCategory(stringValues.get("taxThreshCategory"))
                .taxThreshDesc(stringValues.get("taxThreshDesc"))
                .taxPercentage(taxPercentage)
                .build();
        return taxThresholds;
    }
}
