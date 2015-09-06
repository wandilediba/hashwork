package hashwork.factories.payroll.ui.deductions;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.deductions.LeaveTypeList;

import java.util.Map;

/**
 * Created by zamzam on 15/09/05.
 */
public class LeaveTypeListFactory {
    public static LeaveTypeList getLeaveTypeList(Map<String,String> values,
                                                 boolean paidLeave,
                                                 int maxLeaveDays){
        LeaveTypeList leaveTypeList = new LeaveTypeList
                .Builder()
                .id(KeyGenerator.getEntityId())
                .leaveType(values.get("leavetype"))
                .description(values.get("desc"))
                .paidLeave(paidLeave)
                .maxLeaveDays(maxLeaveDays).build();
        return leaveTypeList;
    }
}
