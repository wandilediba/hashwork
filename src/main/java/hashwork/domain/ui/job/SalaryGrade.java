package hashwork.domain.ui.job;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/16.
 */
public class SalaryGrade implements Serializable {

    private static long serialVersionUID = 1L;
    private String id;
    private String gradeName;
    private String notes;
    private BigDecimal midAmount;
    private BigDecimal endAmount;
    private BigDecimal startAmount;
    private BigDecimal currentAmount;
    private String currencyId;

    public String getId() {
        return id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public String getNotes() {
        return notes;
    }

    public BigDecimal getMidAmount() {
        return midAmount;
    }

    public BigDecimal getEndAmount() {
        return endAmount;
    }

    public BigDecimal getStartAmount() {
        return startAmount;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    private SalaryGrade(){

    }

    private SalaryGrade(Builder builder){
        this.id = builder.id;
        this.gradeName = builder.gradeName;
        this.notes = builder.notes;
        this.midAmount = builder.midAmount;
        this.endAmount = builder.endAmount;
        this.startAmount = builder.startAmount;
        this.currentAmount = builder.currentAmount;
        this.currencyId = builder.currencyId;
    }

    public static class Builder{
        private String id;
        private String gradeName;
        private String notes;
        private BigDecimal midAmount;
        private BigDecimal endAmount;
        private BigDecimal startAmount;
        private BigDecimal currentAmount;
        private String currencyId;

        public Builder id(String value){
            this.id = value;
            return  this;
        }
        public Builder gradeName(String value){
            this.gradeName = value;
            return  this;
        }
        public Builder notes(String value){
            this.notes = value;
            return  this;
        }
        public Builder midAmount(BigDecimal value){
            this.midAmount = value;
            return  this;
        }
        public Builder endAmount(BigDecimal value){
            this.endAmount = value;
            return  this;
        }
        public Builder startAmount(BigDecimal value){
            this.startAmount = value;
            return  this;
        }
        public Builder currentAmount(BigDecimal value){
            this.currentAmount = value;
            return  this;
        }
        public Builder currencyId(String value){
            this.currencyId = value;
            return  this;
        }

        public Builder copy(SalaryGrade value) {
            this.id = value.id;
            this.gradeName = value.gradeName;
            this.notes = value.notes;
            this.midAmount = value.midAmount;
            this.endAmount = value.endAmount;
            this.startAmount = value.startAmount;
            this.currentAmount = value.currentAmount;
            this.currencyId = value.currencyId;
            return this;
        }

        public SalaryGrade build(){
            return new SalaryGrade(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalaryGrade)) return false;

        SalaryGrade that = (SalaryGrade) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getGradeName() != null ? !getGradeName().equals(that.getGradeName()) : that.getGradeName() != null)
            return false;
        if (getNotes() != null ? !getNotes().equals(that.getNotes()) : that.getNotes() != null) return false;
        if (getMidAmount() != null ? !getMidAmount().equals(that.getMidAmount()) : that.getMidAmount() != null)
            return false;
        if (getEndAmount() != null ? !getEndAmount().equals(that.getEndAmount()) : that.getEndAmount() != null)
            return false;
        if (getStartAmount() != null ? !getStartAmount().equals(that.getStartAmount()) : that.getStartAmount() != null)
            return false;
        if (getCurrentAmount() != null ? !getCurrentAmount().equals(that.getCurrentAmount()) : that.getCurrentAmount() != null)
            return false;
        return !(getCurrencyId() != null ? !getCurrencyId().equals(that.getCurrencyId()) : that.getCurrencyId() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getGradeName() != null ? getGradeName().hashCode() : 0);
        result = 31 * result + (getNotes() != null ? getNotes().hashCode() : 0);
        result = 31 * result + (getMidAmount() != null ? getMidAmount().hashCode() : 0);
        result = 31 * result + (getEndAmount() != null ? getEndAmount().hashCode() : 0);
        result = 31 * result + (getStartAmount() != null ? getStartAmount().hashCode() : 0);
        result = 31 * result + (getCurrentAmount() != null ? getCurrentAmount().hashCode() : 0);
        result = 31 * result + (getCurrencyId() != null ? getCurrencyId().hashCode() : 0);
        return result;
    }
}
