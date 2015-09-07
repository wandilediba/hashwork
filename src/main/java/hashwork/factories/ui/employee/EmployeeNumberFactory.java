package hashwork.factories.ui.employee;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.employee.EmployeeNumber;

/**
 * Created by garran on 2015/09/06.
 */
public class EmployeeNumberFactory {
    public static EmployeeNumber getEmployeeNumber(String value) {
        EmployeeNumber employeeNumber = new EmployeeNumber.Builder()
                .id(KeyGenerator.getEntityId())
                .employeeNumber(value).build();
        return employeeNumber;
    }
}
