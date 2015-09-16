package hashwork.domain.payroll.core.deductions;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeDeductions implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String personId;
    private BigDecimal deductionAmt;
    private String deductionTypeDesc;

    //Getters

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public BigDecimal getDeductionAmt() {
        return deductionAmt;
    }

    public String getDeductionTypeDesc() {
        return deductionTypeDesc;
    }

    private EmployeeDeductions() {

    }

    //builder declaration

    private EmployeeDeductions(Builder builder) {
        this.id = builder.id;
        this.personId = builder.personId;
        this.deductionAmt = builder.deductionAmt;
        this.deductionTypeDesc = builder.deductionTypeDesc;

    }

    //builder class

    public static class Builder {
        private String id;
        private String personId;
        private BigDecimal deductionAmt;
        private String deductionTypeDesc;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder personId(String value) {
            this.personId = value;
            return this;
        }

        public Builder deductionAmt(BigDecimal value) {
            this.deductionAmt = value;
            return this;
        }

        public Builder deductionTypeDesc(String value) {
            this.deductionTypeDesc = value;
            return this;
        }

        public Builder copy(EmployeeDeductions value) {
            this.id = value.id;
            this.personId = value.personId;
            this.deductionAmt = value.deductionAmt;
            this.deductionTypeDesc = value.deductionTypeDesc;
            return this;
        }

        public EmployeeDeductions build() {
            return new EmployeeDeductions(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDeductions)) return false;

        EmployeeDeductions that = (EmployeeDeductions) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getPersonId() != null ? !getPersonId().equals(that.getPersonId()) : that.getPersonId() != null)
            return false;
        if (getDeductionAmt() != null ? !getDeductionAmt().equals(that.getDeductionAmt()) : that.getDeductionAmt() != null)
            return false;
        return !(getDeductionTypeDesc() != null ? !getDeductionTypeDesc().equals(that.getDeductionTypeDesc()) : that.getDeductionTypeDesc() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPersonId() != null ? getPersonId().hashCode() : 0);
        result = 31 * result + (getDeductionAmt() != null ? getDeductionAmt().hashCode() : 0);
        result = 31 * result + (getDeductionTypeDesc() != null ? getDeductionTypeDesc().hashCode() : 0);
        return result;
    }
}

