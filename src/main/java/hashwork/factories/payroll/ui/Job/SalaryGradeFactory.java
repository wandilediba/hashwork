package hashwork.factories.payroll.ui.Job;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.job.SalaryGrade;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by zamzam on 15/09/06.
 */
public class SalaryGradeFactory {
    public static SalaryGrade getSalaryGrade(Map<String, String> values,
                                             Map<String, BigDecimal> amounts){
        SalaryGrade salaryGrade = new SalaryGrade
                .Builder()
                .id(KeyGenerator.getEntityId())
                .gradeName(values.get("gradeName"))
                .notes(values.get("notes"))
                .midAmount(amounts.get("midAmount"))
                .endAmount(amounts.get("endAmount"))
                .startAmount(amounts.get("startAmount"))
                .currentAmount(amounts.get("currentAmount"))
                .currencyId(values.get("currId")).build();
        return salaryGrade;
    }
}
