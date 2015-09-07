package hashwork.factories.payroll.ui.Job;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.EarningsList;

import java.util.Map;

/**
 * Created by zamzam on 15/09/07.
 */
public class EarningsListFactory {
    public static EarningsList getEarningsList(Map<String,String> values){
        EarningsList earningsList = new EarningsList
                .Builder()
                .id(KeyGenerator.getEntityId())
                .earningsType(values.get("earningType"))
                .earningsDesc(values.get("earningDesc")).build();
        return earningsList;
    }
}
