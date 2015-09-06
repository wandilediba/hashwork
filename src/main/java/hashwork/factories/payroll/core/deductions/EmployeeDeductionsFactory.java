package hashwork.factories.payroll.core.deductions;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.core.deductions.EmployeeDeductions;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by zamzam on 15/09/05.
 */
public class EmployeeDeductionsFactory {
    public static EmployeeDeductions getEmployeeDeductions(Map<String, String> values,
                                                                  BigDecimal deductionAmt){
        EmployeeDeductions employeeDeductions = new EmployeeDeductions
                .Builder()
                .id(KeyGenerator.getEntityId())
                .personId(values.get("personId"))
                .deductionAmt(deductionAmt)
                .deductionTypeDesc(values.get("deductionTypeDesc"))
                .build();
        return employeeDeductions;
    }
}
