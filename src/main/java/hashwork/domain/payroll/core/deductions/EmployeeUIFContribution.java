package hashwork.domain.payroll.core.deductions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeUIFContribution implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String personId;
    private String country;
    private BigDecimal contribution;
    private BigDecimal currentAmount;
    private Date lastContributionDate;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getCountry() {
        return country;
    }

    public BigDecimal getContribution() {
        return contribution;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public Date getLastContributionDate() {
        return lastContributionDate;
    }

    private EmployeeUIFContribution(){}

    private EmployeeUIFContribution(Builder builder){
        this.id = builder.id;
        this.personId = builder.personId;
        this.country = builder.country;
        this.contribution = builder.contribution;
        this.currentAmount = builder.currentAmount;
        this.lastContributionDate = builder.lastContributionDate;
    }

    public static class Builder{
        private String id;
        private String personId;
        private String country;
        private BigDecimal contribution;
        private BigDecimal currentAmount;
        private Date lastContributionDate;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder personaId(String value){
            this.personId = value;
            return this;
        }
        public Builder country(String value){
            this.country = value;
            return this;
        }
        public Builder contribution(BigDecimal value){
            this.contribution = value;
            return this;
        }
        public Builder currentAmount(BigDecimal value){
            this.currentAmount = value;
            return this;
        }
        public Builder lastContributionDate(Date value){
            this.lastContributionDate = value;
            return this;
        }

        public Builder copy(EmployeeUIFContribution value) {
            this.id = value.id;
            this.personId = value.personId;
            this.country = value.country;
            this.contribution = value.contribution;
            this.currentAmount = value.currentAmount;
            this.lastContributionDate = value.lastContributionDate;
            return this;
        }
        public EmployeeUIFContribution build(){return new EmployeeUIFContribution(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeUIFContribution)) return false;

        EmployeeUIFContribution that = (EmployeeUIFContribution) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getPersonId() != null ? !getPersonId().equals(that.getPersonId()) : that.getPersonId() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(that.getCountry()) : that.getCountry() != null) return false;
        if (getContribution() != null ? !getContribution().equals(that.getContribution()) : that.getContribution() != null)
            return false;
        if (getCurrentAmount() != null ? !getCurrentAmount().equals(that.getCurrentAmount()) : that.getCurrentAmount() != null)
            return false;
        return !(getLastContributionDate() != null ? !getLastContributionDate().equals(that.getLastContributionDate()) : that.getLastContributionDate() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPersonId() != null ? getPersonId().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getContribution() != null ? getContribution().hashCode() : 0);
        result = 31 * result + (getCurrentAmount() != null ? getCurrentAmount().hashCode() : 0);
        result = 31 * result + (getLastContributionDate() != null ? getLastContributionDate().hashCode() : 0);
        return result;
    }
}
