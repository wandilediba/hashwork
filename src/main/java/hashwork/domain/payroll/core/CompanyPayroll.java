package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class CompanyPayroll implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String companyId;
    private Date payPeriod;
    private String employeeType;
    
    public String getId() {
        return id;
    }
    
    public String getCompanyId() {
        return companyId;
    }
    
    public Date getPayPeriod() {
        return payPeriod;
    }
    
    public String getEmployeeType() {
        return employeeType;
    }
    
    private CompanyPayroll(){

    }
    
     private CompanyPayroll(Builder builder){
        this.id = builder.id;
        this.companyId = builder.companyId;
        this.payPeriod = builder.payPeriod;
        this.employeeType = builder.employeeType;
    }
     
    public static class Builder{
        private String id;
        private String companyId;
        private Date payPeriod;
        private String employeeType;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        
        public Builder companyId(String value){
            this.companyId = value;
            return this;
        }
        
        public Builder payPeriod(Date value){
            this.payPeriod = value;
            return this;
        }
        
          public Builder employeeType(String value){
            this.employeeType = value;
            return this;
        }

        public Builder copy(CompanyPayroll value) {
            this.id = value.id;
            this.companyId = value.companyId;
            this.payPeriod = value.payPeriod;
            this.employeeType = value.employeeType;
            return this;
        }

        public CompanyPayroll build() {
            return new CompanyPayroll(this);
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyPayroll)) return false;

        CompanyPayroll companypayroll = (CompanyPayroll) o;

        if (getId() != null ? !getId().equals(companypayroll.getId()) : companypayroll.getId() != null) return false;
        if (getCompanyId() != null ? !getCompanyId().equals(companypayroll.getCompanyId()) : companypayroll.getCompanyId() != null)
            return false;
        if (getPayPeriod() != null ? !getPayPeriod().equals(companypayroll.getPayPeriod()) : companypayroll.getPayPeriod() != null) return false;
        return !(getEmployeeType() != null ? !getPayPeriod().equals(companypayroll.getEmployeeType()) : companypayroll.getEmployeeType() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCompanyId() != null ? getCompanyId().hashCode() : 0);
        result = 31 * result + (getPayPeriod() != null ? getPayPeriod().hashCode() : 0);
        result = 31 * result + (getEmployeeType() != null ? getEmployeeType().hashCode() : 0);
        return result;
    }
}

