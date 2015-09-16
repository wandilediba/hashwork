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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    private CompanyPayroll() {
    }

    private CompanyPayroll(Builder builder) {
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

        public Builder employeeType(String value) {
            this.employeeType = value;
            return this;
        }

        public Builder copy(CompanyPayroll value) {
            this.id = value.id;
            this.companyId = value.companyId;
            this.employeeType = value.employeeType;
            this.payPeriod = value.payPeriod;
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

        CompanyPayroll that = (CompanyPayroll) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (companyId != null ? !companyId.equals(that.companyId) : that.companyId != null) return false;
        if (payPeriod != null ? !payPeriod.equals(that.payPeriod) : that.payPeriod != null) return false;
        return !(employeeType != null ? !employeeType.equals(that.employeeType) : that.employeeType != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (payPeriod != null ? payPeriod.hashCode() : 0);
        result = 31 * result + (employeeType != null ? employeeType.hashCode() : 0);
        return result;
    }
}
