package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeTaxCertificate implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String personId;
    private String employer;
    private String taxReferenceNumber;
    private String uifNumber;
    private BigDecimal employeeTaxAmt;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getEmployer() {
        return employer;
    }

    public String getTaxReferenceNumber() {
        return taxReferenceNumber;
    }

    public String getUifNumber() {
        return uifNumber;
    }

    public BigDecimal getEmployeeTaxAmt() {
        return employeeTaxAmt;
    }

    private EmployeeTaxCertificate() {
    }

    private EmployeeTaxCertificate(Builder builder) {
        this.id = builder.id;
        this.personId = builder.personId;
        this.employer = builder.employer;
        this.taxReferenceNumber = builder.taxReferenceNumber;
        this.uifNumber = builder.uifNumber;
        this.employeeTaxAmt = builder.employeeTaxAmt;
    }

    public static class Builder{
        private String id;
        private String personId;
        private String employer;
        private String taxReferenceNumber;
        private String uifNumber;
        private BigDecimal employeeTaxAmt;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.personId = value;
            return this;
        }

        public Builder employer(String value){
            this.employer = value;
            return this;
        }

        public Builder taxReferenceNumber(String value){
            this.taxReferenceNumber = value;
            return this;
        }

        public Builder uifNumber(String value) {
            this.uifNumber = value;
            return this;
        }

        public Builder employeeTaxAmt(BigDecimal value){
            this.employeeTaxAmt = value;
            return this;
        }

        public Builder copy(EmployeeTaxCertificate value) {
            this.id = value.id;
            this.personId = value.personId;
            this.employer = value.employer;
            this.uifNumber = value.uifNumber;
            this.taxReferenceNumber = value.taxReferenceNumber;
            this.employeeTaxAmt = value.employeeTaxAmt;
            return this;
        }

        public EmployeeTaxCertificate build(){
            return new EmployeeTaxCertificate(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeTaxCertificate)) return false;

        EmployeeTaxCertificate that = (EmployeeTaxCertificate) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;
        if (employer != null ? !employer.equals(that.employer) : that.employer != null) return false;
        if (taxReferenceNumber != null ? !taxReferenceNumber.equals(that.taxReferenceNumber) : that.taxReferenceNumber != null)
            return false;
        if (uifNumber != null ? !uifNumber.equals(that.uifNumber) : that.uifNumber != null) return false;
        return !(employeeTaxAmt != null ? !employeeTaxAmt.equals(that.employeeTaxAmt) : that.employeeTaxAmt != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (employer != null ? employer.hashCode() : 0);
        result = 31 * result + (taxReferenceNumber != null ? taxReferenceNumber.hashCode() : 0);
        result = 31 * result + (uifNumber != null ? uifNumber.hashCode() : 0);
        result = 31 * result + (employeeTaxAmt != null ? employeeTaxAmt.hashCode() : 0);
        return result;
    }
}
