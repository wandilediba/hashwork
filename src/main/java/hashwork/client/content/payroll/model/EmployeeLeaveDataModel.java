package hashwork.client.content.payroll.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeLeaveDataModel implements Serializable {
   
    private String personId;
    private String leaveType;
    private boolean paidLeave;
    private int daysTaken;
    private Date commencementDate;

    public String getPersonId() {
        return personId;
    }
    
     public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getLeaveType() {
        return leaveType;
    }
    
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public boolean isPaidLeave() {
        return paidLeave;
    }
    
    public void setIsPaidLeave(boolean paidLeave) {
        this.paidLeave = paidLeave;
    }

    public int getDaysTaken() {
        return daysTaken;
    }
    
    public void setDaysTaken(int daysTaken) {
        this.daysTaken = daysTaken;
    }

    public Date getCommencementDate() {
        return commencementDate;
    }
    
     public void setCommencementDate(Date commencementDate) {
        this.commencementDate = commencementDate;
    }
}
