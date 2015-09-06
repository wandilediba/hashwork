package hashwork.factories.payroll.core.deductions;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.core.deductions.EmployeeUIFContribution;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Created by zamzam on 15/09/05.
 */
public class EmployeeUIFContributionFactory {
    public static EmployeeUIFContribution getEmployeeUIFContribution(Map<String,String> values,
                                                                     Map<String, BigDecimal> amounts,
                                                                     Date lastContributionDate){
        EmployeeUIFContribution employeeUIFContribution = new EmployeeUIFContribution
                .Builder()
                .id(KeyGenerator.getEntityId())
                .personaId(values.get("personId"))
                .country(values.get("counry"))
                .contribution(amounts.get("contribution"))
                .currentAmount(amounts.get("currentAmount"))
                .lastContributionDate(lastContributionDate).build();
        return employeeUIFContribution;
    }
}
