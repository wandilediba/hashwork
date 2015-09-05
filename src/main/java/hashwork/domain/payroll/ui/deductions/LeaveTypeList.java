package hashwork.domain.payroll.ui.deductions;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/17.
 */
public class LeaveTypeList implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String leaveType;
    private String description;
    private boolean paidLeave;
    private int maxLeaveDays;

    public String getId() {
        return id;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPaidLeave() {
        return paidLeave;
    }

    public int getMaxLeaveDays() {
        return maxLeaveDays;
    }
    private LeaveTypeList(){ }
    private LeaveTypeList(Builder builder){
        this.id = builder.id;
        this.leaveType = builder.leaveType;
        this.description = builder.description;
        this.paidLeave = builder.paidLeave;
        this.maxLeaveDays = builder.maxLeaveDays;
    }

    public static class Builder {
        private String id;
        private String leaveType;
        private String description;
        private boolean paidLeave;
        private int maxLeaveDays;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder leaveType(String value){
            this.leaveType = value;
            return this;
        }
        public Builder description(String value){
            this.description = value;
            return this;
        }
        public Builder paidLeave(boolean value){
            this.paidLeave = value;
            return this;
        }
        public Builder maxLeaveDays(int value){
            this.maxLeaveDays = value;
            return this;
        }

        public Builder copy(LeaveTypeList value) {
            this.id = value.id;
            this.leaveType = value.leaveType;
            this.description = value.description;
            this.paidLeave = value.paidLeave;
            this.maxLeaveDays = value.maxLeaveDays;
            return this;
        }

        public LeaveTypeList build() {
            return new LeaveTypeList(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeaveTypeList)) return false;

        LeaveTypeList that = (LeaveTypeList) o;

        if (isPaidLeave() != that.isPaidLeave()) return false;
        if (getMaxLeaveDays() != that.getMaxLeaveDays()) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getLeaveType() != null ? !getLeaveType().equals(that.getLeaveType()) : that.getLeaveType() != null)
            return false;
        return !(getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getLeaveType() != null ? getLeaveType().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (isPaidLeave() ? 1 : 0);
        result = 31 * result + getMaxLeaveDays();
        return result;
    }

    @Override
    public String toString() {
        return "LeaveTypeListFactory{" +
                "id=" + id +
                ", leaveType='" + leaveType + '\'' +
                ", description='" + description + '\'' +
                ", paidLeave=" + paidLeave +
                ", maxLeaveDays=" + maxLeaveDays +
                '}';
    }
}
