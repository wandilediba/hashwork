package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeePayslip implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String personId;
    private BigDecimal netPay;
    private Date payslipGenerateDate;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public BigDecimal getNetPay() {
        return netPay;
    }

    public Date getPayslipGenerateDate() {
        return payslipGenerateDate;
    }

    private EmployeePayslip() {
    }

    private EmployeePayslip(Builder builder) {
        this.id = builder.id;
        this.personId = builder.personId;
        this.netPay = builder.netPay;
        this.payslipGenerateDate = builder.payslipGenerateDate;
    }

    public static class Builder{
        private String id;
        private String personId;
        private BigDecimal netPay;
        private Date payslipGenerateDate;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.personId = value;
            return this;
        }

        public Builder netPay(BigDecimal value){
            this.netPay = value;
            return this;
        }

        public Builder payslipGenerateDate(Date value){
            this.payslipGenerateDate = value;
            return this;
        }

        public Builder copy(EmployeePayslip value) {
            this.id = value.id;
            this.personId = value.personId;
            this.netPay = value.netPay;
            this.payslipGenerateDate = value.payslipGenerateDate;
            return this;
        }

        public EmployeePayslip build(){
            return new EmployeePayslip(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeePayslip)) return false;

        EmployeePayslip that = (EmployeePayslip) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getPersonId() != null ? !getPersonId().equals(that.getPersonId()) : that.getPersonId() != null)
            return false;
        if (getNetPay() != null ? !getNetPay().equals(that.getNetPay()) : that.getNetPay() != null) return false;
        return !(getPayslipGenerateDate() != null ? !getPayslipGenerateDate().equals(that.getPayslipGenerateDate()) : that.getPayslipGenerateDate() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPersonId() != null ? getPersonId().hashCode() : 0);
        result = 31 * result + (getNetPay() != null ? getNetPay().hashCode() : 0);
        result = 31 * result + (getPayslipGenerateDate() != null ? getPayslipGenerateDate().hashCode() : 0);
        return result;
    }
}
