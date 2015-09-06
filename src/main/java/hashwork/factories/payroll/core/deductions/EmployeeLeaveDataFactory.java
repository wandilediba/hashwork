package hashwork.factories.payroll.core.deductions;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.core.deductions.EmployeeLeaveData;

import java.util.Date;
import java.util.Map;

/**
 * Created by zamzam on 15/09/05.
 */
public class EmployeeLeaveDataFactory {
    public static EmployeeLeaveData getEmployeeLeaveData(Map<String,String> values,
                                                         boolean paidLeave, int daysTaken,
                                                         Date commencementDate){
        EmployeeLeaveData employeeLeaveData = new EmployeeLeaveData
                .Builder()
                .id(KeyGenerator.getEntityId())
                .personId(values.get("personId"))
                .leaveType(values.get("leaveType"))
                .paidLeave(paidLeave)
                .daysTaken(daysTaken)
                .commencementDate(commencementDate)
                .build();
        return employeeLeaveData;
    }
}
