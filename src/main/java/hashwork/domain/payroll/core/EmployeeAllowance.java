package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeAllowance implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String personId;
    private String allowanceType;
    private BigDecimal amount;
    private Date validAsFrom;
    
    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getAllowanceType() {
        return allowanceType;
    }
    
     public BigDecimal getAmount() {
        return amount;
    }

    public Date getValidAsFrom() {
        return validAsFrom;
    }
    
    
    private EmployeeAllowance(){

    }
    
     private EmployeeAllowance(Builder builder){
        this.id = builder.id;
        this.personId = builder.personId;
        this.allowanceType = builder.allowanceType;
        this.amount = builder.amount;
        this.validAsFrom = builder.validAsFrom;
    }

    public static class Builder{
        private String id;
        private String personId;
        private String allowanceType;
        private BigDecimal amount;
        private Date validAsFrom;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder personId(String value){
            this.personId = value;
            return this;
        }
        public Builder allowanceType(String value){
            this.allowanceType = value;
            return this;
        }
         public Builder amount(BigDecimal value){
            this.amount = value;
            return this;
        }
        public Builder validAsFrom(Date value){
            this.validAsFrom = value;
            return this;
        }

        public Builder copy(EmployeeAllowance value) {
            this.id = value.id;
            this.personId = value.personId;
            this.allowanceType = value.allowanceType;
            this.amount = value.amount;
            this.validAsFrom = value.validAsFrom;
            return this;
        }

        public EmployeeAllowance build() {
            return new EmployeeAllowance(this);
        }
        
    }
        
    @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeAllowance)) return false;

        EmployeeAllowance employeeAllowance = (EmployeeAllowance) o;

        if (getId() != null ? !getId().equals(employeeAllowance.getId()) : employeeAllowance.getId() != null) return false;
        if (getPersonId() != null ? !getPersonId().equals(employeeAllowance.getPersonId()) : employeeAllowance.getPersonId() != null)
            return false;
        if (getAllowanceType() != null ? !getAllowanceType().equals(employeeAllowance.getAllowanceType()) : employeeAllowance.getAllowanceType() != null) return false;
        if (getAmount() != null ? !getAmount().equals(employeeAllowance.getAmount()) : employeeAllowance.getAmount() != null)
            return false;
        return !(getValidAsFrom() != null ? !getValidAsFrom().equals(employeeAllowance.getValidAsFrom()) : employeeAllowance.getValidAsFrom() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPersonId() != null ? getPersonId().hashCode() : 0);
        result = 31 * result + (getAllowanceType() != null ? getAllowanceType().hashCode() : 0);
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        result = 31 * result + (getValidAsFrom() != null ? getValidAsFrom().hashCode() : 0);
        return result;
    }
}
