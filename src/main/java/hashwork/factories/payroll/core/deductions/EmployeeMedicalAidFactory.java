package hashwork.factories.payroll.core.deductions;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.core.deductions.EmployeeMedicalAid;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Created by zamzam on 15/09/05.
 */
public class EmployeeMedicalAidFactory {
    public static EmployeeMedicalAid getEmployeeMedicalAid(Map<String,String> values,
                                                           BigDecimal medicalAidAmount,
                                                           Date lastDateContribution){
        EmployeeMedicalAid employeeMedicalAid = new EmployeeMedicalAid
                .Builder()
                .id(KeyGenerator.getEntityId())
                .personId(values.get("personId"))
                .medicalAidType(values.get("medicalAidType"))
                .medicalAidAmount(medicalAidAmount)
                .lastDateContribution(lastDateContribution)
                .build();

        return employeeMedicalAid;
    }
}
