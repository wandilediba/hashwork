package hashwork.client.content.payroll.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/17.
 */
public class LeaveTypeListModel implements Serializable {
    private String leaveType;
    private String description;
    private boolean paidLeave;
    private int maxLeaveDays;

    public String getLeaveType() {
        return leaveType;
    }
    
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPaidLeave() {
        return paidLeave;
    }
    
    public void setIsPaidLeave(boolean paidLeave) {
        this.paidLeave = paidLeave;
    }

    public int getMaxLeaveDays() {
        return maxLeaveDays;
    }
    
    public void setMaxLeaveDays(int maxLeaveDays) {
        this.maxLeaveDays = maxLeaveDays;
    }

}
