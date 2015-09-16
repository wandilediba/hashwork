package hashwork.domain.payroll.core.deductions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeePension implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String personId;
    private Date startDate;
    private String pensionCode;
    private BigDecimal goalAmount;
    private BigDecimal lastContribution;
    private Date lastContributionDate;
    private BigDecimal contributionToDate;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getPensionCode() {
        return pensionCode;
    }

    public BigDecimal getGoalAmount() {
        return goalAmount;
    }

    public BigDecimal getLastContribution() {
        return lastContribution;
    }

    public Date getLastContributionDate() {
        return lastContributionDate;
    }

    public BigDecimal getContributionToDate() {
        return contributionToDate;
    }

    private EmployeePension(){}

    private EmployeePension(Builder builder){
        this.id = builder.id;
        this.personId = builder.personId;
        this.startDate = builder.startDate;
        this.pensionCode = builder.pensionCode;
        this.goalAmount = builder.goalAmount;
        this.lastContribution = builder.lastContribution;
        this.lastContributionDate = builder.lastContributionDate;
        this.contributionToDate = builder.contributionToDate;
    }

    public static class Builder{
        private String id;
        private String personId;
        private Date startDate;
        private String pensionCode;
        private BigDecimal goalAmount;
        private BigDecimal lastContribution;
        private Date lastContributionDate;
        private BigDecimal contributionToDate;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.personId = value;
            return this;
        }
        public Builder startDate(Date value){
            this.startDate = value;
            return this;
        }
        public Builder pensionCode(String value){
            this.pensionCode = value;
            return this;
        }
        public Builder goalAmount(BigDecimal value){
            this.goalAmount = value;
            return this;
        }
        public Builder lastConstribution(BigDecimal value){
            this.lastContribution = value;
            return this;
        }
        public Builder lastContributionDate(Date value){
            this.lastContributionDate = value;
            return this;
        }
        public Builder contributionToDate(BigDecimal value){
            this.contributionToDate = value;
            return this;
        }

        public Builder copy(EmployeePension value) {
            this.id = value.id;
            this.personId = value.personId;
            this.startDate = value.startDate;
            this.pensionCode = value.pensionCode;
            this.goalAmount = value.goalAmount;
            this.lastContribution = value.lastContribution;
            this.lastContributionDate = value.lastContributionDate;
            this.contributionToDate = value.contributionToDate;

            return this;
        }
        public EmployeePension build(){return new EmployeePension(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeePension)) return false;

        EmployeePension that = (EmployeePension) o;

        if (!getId().equals(that.getId())) return false;
        if (!getPersonId().equals(that.getPersonId())) return false;
        if (!getStartDate().equals(that.getStartDate())) return false;
        if (!getPensionCode().equals(that.getPensionCode())) return false;
        if (!getGoalAmount().equals(that.getGoalAmount())) return false;
        if (!getLastContribution().equals(that.getLastContribution())) return false;
        if (!getLastContributionDate().equals(that.getLastContributionDate())) return false;
        return getContributionToDate().equals(that.getContributionToDate());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getPersonId().hashCode();
        result = 31 * result + getStartDate().hashCode();
        result = 31 * result + getPensionCode().hashCode();
        result = 31 * result + getGoalAmount().hashCode();
        result = 31 * result + getLastContribution().hashCode();
        result = 31 * result + getLastContributionDate().hashCode();
        result = 31 * result + getContributionToDate().hashCode();
        return result;
    }
}
