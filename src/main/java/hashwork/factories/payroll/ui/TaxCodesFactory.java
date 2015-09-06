package hashwork.factories.payroll.ui;

import hashwork.app.util.KeyGenerator;

import hashwork.domain.payroll.ui.TaxCodes;


import java.util.Map;

/**
 * Created by nkosi on 2015/09/02.
 */

public class TaxCodesFactory {
    public static TaxCodes getTaxCodes(Map<String, String> values, String codeDecription) {
        TaxCodes taxCodes = new TaxCodes
                .Builder()
                .id(KeyGenerator.getEntityId())
                .code(values.get("code"))
                .codeType(values.get("codeType"))
                .codeDecription("codeDescription")
                .build();
        return taxCodes;
    }
}