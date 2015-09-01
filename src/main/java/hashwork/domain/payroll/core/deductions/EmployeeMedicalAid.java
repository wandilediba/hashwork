package hashwork.domain.payroll.core.deductions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeMedicalAid implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String personId;
    private String medicalAidType;
    private BigDecimal medicalAidAmount;
    private Date lastDateContribution;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getMedicalAidType() {
        return medicalAidType;
    }

    public BigDecimal getMedicalAidAmount() {
        return medicalAidAmount;
    }

    public Date getLastDateContribution() {
        return lastDateContribution;
    }

    private EmployeeMedicalAid(){}

    private EmployeeMedicalAid(Builder builder){
        this.id = builder.id;
        this.personId = builder.personId;
        this.medicalAidType = builder.medicalAidType;
        this.medicalAidAmount = builder.medicalAidAmount;
        this.lastDateContribution = builder.lastDateContribution;
    }


    public static class Builder{
        private String id;
        private String personId;
        private String medicalAidType;
        private BigDecimal medicalAidAmount;
        private Date lastDateContribution;

        public Builder id(String value){
            this.id = value; return this;}

        public Builder personId(String value){
            this.personId = value;
            return this;
        }
        public Builder medicalAidType(String value){
            this.medicalAidType = value;
            return this;
        }
        public Builder medicalAidAmount(BigDecimal value){
            this.medicalAidAmount = value;
            return this;
        }
        public Builder lastDateContribution(Date value){
            this.lastDateContribution = value;
            return this;
        }

        public Builder copy(EmployeeMedicalAid value) {
            this.id = value.id;
            this.personId = value.personId;
            this.medicalAidType = value.medicalAidType;
            this.medicalAidAmount = value.medicalAidAmount;
            this.lastDateContribution = value.lastDateContribution;

            return this;
        }
        public EmployeeMedicalAid build(){return new EmployeeMedicalAid(this);}

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeMedicalAid)) return false;

        EmployeeMedicalAid that = (EmployeeMedicalAid) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getPersonId() != null ? !getPersonId().equals(that.getPersonId()) : that.getPersonId() != null)
            return false;
        if (getMedicalAidType() != null ? !getMedicalAidType().equals(that.getMedicalAidType()) : that.getMedicalAidType() != null)
            return false;
        if (getMedicalAidAmount() != null ? !getMedicalAidAmount().equals(that.getMedicalAidAmount()) : that.getMedicalAidAmount() != null)
            return false;
        return !(getLastDateContribution() != null ? !getLastDateContribution().equals(that.getLastDateContribution()) : that.getLastDateContribution() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPersonId() != null ? getPersonId().hashCode() : 0);
        result = 31 * result + (getMedicalAidType() != null ? getMedicalAidType().hashCode() : 0);
        result = 31 * result + (getMedicalAidAmount() != null ? getMedicalAidAmount().hashCode() : 0);
        result = 31 * result + (getLastDateContribution() != null ? getLastDateContribution().hashCode() : 0);
        return result;
    }
}