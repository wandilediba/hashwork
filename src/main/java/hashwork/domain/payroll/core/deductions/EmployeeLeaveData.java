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

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public boolean isPaidLeave() {
        return paidLeave;
    }

    public int getDaysTaken() {
        return daysTaken;
    }

    public Date getCommencementDate() {
        return commencementDate;
    }

    private EmployeeLeaveData(){

    }

    private EmployeeLeaveData(Builder builder){
        this.id = builder.id;
        this.personId = builder.personId;
        this.leaveType = builder.leaveType;
        this.paidLeave = builder.paidLeave;
        this.daysTaken = builder.daysTaken;
        this.commencementDate = builder.commencementDate;
    }

    public static class Builder{
        private String id;
        private String personId;
        private String leaveType;
        private boolean paidLeave;
        private int daysTaken;
        private Date commencementDate;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value) {
            this.personId = value;
            return this;
        }

        public Builder leaveType(String value) {
            this.leaveType = value;
            return this;
        }

        public Builder paidLeave(boolean value) {
            this.paidLeave = value;
            return this;
        }

        public Builder daysTaken(int value) {
            this.daysTaken = value;
            return this;
        }

        public Builder commencementDate(Date value) {
            this.commencementDate = value;
            return this;
        }

        public Builder copy(EmployeeLeaveData value) {
            this.id = value.id;
            this.personId = value.personId;
            this.leaveType = value.leaveType;
            this.paidLeave = value.paidLeave;
            this.daysTaken = value.daysTaken;
            this.commencementDate = value.commencementDate;
            return this;
        }
        public EmployeeLeaveData build(){return new EmployeeLeaveData(this);}


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeLeaveData)) return false;

        EmployeeLeaveData that = (EmployeeLeaveData) o;

        if (isPaidLeave() != that.isPaidLeave()) return false;
        if (getDaysTaken() != that.getDaysTaken()) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getPersonId() != null ? !getPersonId().equals(that.getPersonId()) : that.getPersonId() != null)
            return false;
        if (getLeaveType() != null ? !getLeaveType().equals(that.getLeaveType()) : that.getLeaveType() != null)
            return false;
        return !(getCommencementDate() != null ? !getCommencementDate().equals(that.getCommencementDate()) : that.getCommencementDate() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPersonId() != null ? getPersonId().hashCode() : 0);
        result = 31 * result + (getLeaveType() != null ? getLeaveType().hashCode() : 0);
        result = 31 * result + (isPaidLeave() ? 1 : 0);
        result = 31 * result + getDaysTaken();
        result = 31 * result + (getCommencementDate() != null ? getCommencementDate().hashCode() : 0);
        return result;
    }
}
