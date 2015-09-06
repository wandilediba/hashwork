package hashwork.factories.payroll.core.deductions;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.core.deductions.EmployeePension;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Created by zamzam on 15/09/05.
 */
public class EmployeePensionFactory {
    public static EmployeePension getEmployeePension(Map<String, String> values,
                                                     Map<String, BigDecimal> amounts,
                                                     Map<String, Date> dates){
        EmployeePension employeePension = new EmployeePension
                .Builder()
                .id(KeyGenerator.getEntityId())
                .pensionCode(values.get("pensionCode"))
                .personId(values.get("personId"))
                .startDate(dates.get("startDate"))
                .goalAmount(amounts.get("goalAmount"))
                .lastContributionDate(dates.get("lastContribution"))
                .lastConstribution(amounts.get("lastContribution"))
                .contributionToDate(amounts.get("contributionToDate")).build();
        return employeePension;

    }
}
