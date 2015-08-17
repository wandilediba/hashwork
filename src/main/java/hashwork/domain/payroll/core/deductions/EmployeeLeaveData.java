package hashwork.domain.payroll.core.deductions;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeLeaveData implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String personId;
    private String leaveType;
    private boolean paidLeave;
    private int daysTaken;
    private Date commencementDate;
}
