package hashwork.factories.payroll.ui.Job;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.TaxCodes;

import java.util.Map;

/**
 * Created by zamzam on 15/09/07.
 */
public class TaxCodesFactory {
    public static TaxCodes getTaxCodes(Map<String,String> values){
        TaxCodes taxCodes = new TaxCodes
                .Builder()
                .id(KeyGenerator.getEntityId())
                .code(values.get("code"))
                .codeType(values.get("codeType"))
                .codeDecription(values.get("codeDesc")).build();
        return taxCodes;
    }
}
