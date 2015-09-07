package hashwork.factories.ui.employee;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.employee.EmployeeType;

/**
 * Created by garran on 2015/09/06.
 */
public class EmployeeTypeFactory {
    public static EmployeeType getEmployeeType(String value) {
        EmployeeType employeeType = new EmployeeType.Builder()
                .id(KeyGenerator.getEntityId())
                .employeeType(value).build();
        return employeeType;
    }
}
