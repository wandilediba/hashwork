package hashwork.domain.payroll.ui.deductions;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class MedicalAidList implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String medicalAidType;
    private String description;
    private BigDecimal monthlyContribution;

    public String getId() {
        return id;
    }

    public String getMedicalAidType() {
        return medicalAidType;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getMonthlyContribution() {
        return monthlyContribution;
    }

    private MedicalAidList() {

    }

    private MedicalAidList(Builder builder) {
        this.id = builder.id;
        this.medicalAidType = builder.medicalAidType;
        this.description = builder.description;
        this.monthlyContribution = builder.monthlyContribution;
    }


    public static class Builder {
        private String id;
        private String medicalAidType;
        private String description;
        private BigDecimal monthlyContribution;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder medicalAidType(String value) {
            this.medicalAidType = value;
            return this;
        }

        public Builder description(String value) {
            this.description = value;
            return this;
        }

        public Builder monthlyContribution(BigDecimal value) {
            this.monthlyContribution = value;
            return this;
        }

        public Builder copy(MedicalAidList value) {
            this.id = value.id;
            this.medicalAidType = value.medicalAidType;
            this.description = value.description;
            this.monthlyContribution = value.monthlyContribution;
            return this;
        }

        public MedicalAidList build() {
            return new MedicalAidList(this);
        }

    }

    @Override
    public String toString() {
        return "MedicalAidList{" +
                "id=" + id +
                ", medicalAidType='" + medicalAidType + '\'' +
                ", description='" + description + '\'' +
                ", monthlyContribution=" + monthlyContribution +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicalAidList)) return false;

        MedicalAidList that = (MedicalAidList) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getMedicalAidType() != null ? !getMedicalAidType().equals(that.getMedicalAidType()) : that.getMedicalAidType() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        return !(getMonthlyContribution() != null ? !getMonthlyContribution().equals(that.getMonthlyContribution()) : that.getMonthlyContribution() != null);

    }

    @Override
    public int hashCode() {
        return 0;
    }
}
