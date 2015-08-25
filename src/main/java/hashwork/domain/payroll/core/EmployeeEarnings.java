package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeEarnings implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String personId;
    private BigDecimal earningsAmt;
    private String earningsTypeDesc;
    private String earningsCode;
    private Date payDate;
    
    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public BigDecimal getEarningsAmt() {
        return earningsAmt;
    }
    
    public String getEarningsTypeDesc() {
        return earningsTypeDesc;
    }

    public String getEarningsCode() {
        return earningsCode;
    }

    public Date getPayDate() {
        return payDate;
    }
        
    private EmployeeEarnings(){

    }
    
    private EmployeeEarnings(Builder builder){
        this.id = builder.id;
        this.personId = builder.personId;
        this.earningsAmt = builder.earningsAmt;
        this.earningsTypeDesc = builder.earningsTypeDesc;
        this.earningsCode = builder.earningsCode;
        this.payDate = builder.payDate;
    }

    public static class Builder{
        private String id;
        private String personId;
        private BigDecimal earningsAmt;
        private String earningsTypeDesc;
        private String earningsCode;
        private Date payDate;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder personId(String value){
            this.personId = value;
            return this;
        }
        public Builder earningsAmt(BigDecimal value){
            this.earningsAmt = value;
            return this;
        }
         public Builder earningsTypeDesc(String value){
            this.earningsTypeDesc = value;
            return this;
        }
        public Builder earningsCode(String value){
            this.earningsCode = value;
            return this;
        }
        public Builder payDate(Date value){
            this.payDate = value;
            return this;
        }

        public Builder copy(EmployeeEarnings value) {
            this.id = value.id;
            this.personId = value.personId;
            this.earningsAmt = value.earningsAmt;
            this.earningsTypeDesc = value.earningsTypeDesc;
            this.earningsCode = value.earningsCode;
            this.payDate = value.payDate;
            return this;
        }

        public EmployeeEarnings build() {
            return new EmployeeEarnings(this);
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeEarnings)) return false;

        EmployeeEarnings employeeEarnings = (EmployeeEarnings) o;

        if (getId() != null ? !getId().equals(employeeEarnings.getId()) : employeeEarnings.getId() != null) return false;
        if (getPersonId() != null ? !getPersonId().equals(employeeEarnings.getPersonId()) : employeeEarnings.getPersonId() != null) return false;
        if (getEarningsAmt() != null ? !getEarningsAmt().equals(employeeEarnings.getEarningsAmt()) : employeeEarnings.getEarningsAmt() != null) return false;
        if (getEarningsTypeDesc() != null ? !getEarningsTypeDesc().equals(employeeEarnings.getEarningsTypeDesc()) : employeeEarnings.getEarningsTypeDesc() != null) return false;
        if (getEarningsCode() != null ? !getEarningsCode().equals(employeeEarnings.getEarningsCode()) : employeeEarnings.getEarningsCode() != null) return false;
        return !(getPayDate() != null ? !getPayDate().equals(employeeEarnings.getPayDate()) : employeeEarnings.getPayDate() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPersonId() != null ? getPersonId().hashCode() : 0);
        result = 31 * result + (getEarningsAmt() != null ? getEarningsAmt().hashCode() : 0);
        result = 31 * result + (getEarningsTypeDesc() != null ? getEarningsTypeDesc().hashCode() : 0);
        result = 31 * result + (getEarningsCode() != null ? getEarningsCode().hashCode() : 0);
        result = 31 * result + (getPayDate() != null ? getPayDate().hashCode() : 0);
        return result;
    }

    
}
