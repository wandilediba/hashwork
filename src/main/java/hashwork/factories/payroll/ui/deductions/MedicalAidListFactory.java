package hashwork.factories.payroll.ui.deductions;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.deductions.MedicalAidList;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by zamzam on 15/09/05.
 */
public class MedicalAidListFactory {
    public static MedicalAidList getMedicalAidList(Map<String, String> values,
                                                   BigDecimal monthlyContribution) {
        MedicalAidList medicalAidList = new MedicalAidList
                .Builder()
                .id(KeyGenerator.getEntityId())
                .monthlyContribution(monthlyContribution)
                .medicalAidType(values.get("medicalAidType"))
                .description(values.get("desc")).build();
        return medicalAidList;
    }
}
