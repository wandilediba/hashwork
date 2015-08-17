package hashwork.domain.payroll.ui.deductions;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/17.
 */
public class LeaveTypeList implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String leaveType;
    private String description;
    private boolean paidLeave;
    private int maxLeaveDays;
}
