package hashwork.factories.payroll.ui;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.EarningsList;

/**
 * Created by nkosi on 2015/09/01.
 */
public class EarningsListFactory {

    public static EarningsList getEarningList(String earningsType, String earningsDesc) {
        EarningsList earningsList = new EarningsList
                .Builder()
                .id(KeyGenerator.getEntityId())
                .earningsType(earningsType)
                .earningsDesc(earningsDesc)
                .build();
        return earningsList;
    }
}
