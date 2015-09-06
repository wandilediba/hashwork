package hashwork.factories.payroll.ui.deductions;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.deductions.AllowanceTypeList;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by zamzam on 15/09/05.
 */
public class AllowanceTypeListFactory {
    public static AllowanceTypeList getAllowanceTypeList(Map<String,String> values,
                                                         BigDecimal maxAmount){
        AllowanceTypeList allowanceTypeList = new AllowanceTypeList
                .Builder()
                .id(KeyGenerator.getEntityId())
                .allowanceType(values.get("allowanceType"))
                .description(values.get("desc"))
                .maxAmount(maxAmount).build();
        
        return allowanceTypeList;
    }
}
