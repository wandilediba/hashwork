package hashwork.domain.payroll.ui.deductions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PensionFund implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String pensionCode;
    private String description;
    private BigDecimal percentage;
    private Date percentageAsOfDate;

    public String getId() {
        return id;
    }

    public String getPensionCode() {
        return pensionCode;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public Date getPercentageAsOfDate() {
        return percentageAsOfDate;
    }

    private PensionFund(){

    }

    private PensionFund(Builder builder){
        this.id = builder.id;
        this.pensionCode = builder.pensionCode;
        this.description = builder.description;
        this.percentage = builder.percentage;
        this.percentageAsOfDate = builder.percentageAsOfDate;
    }

    public static class Builder{
        private String id;
        private String pensionCode;
        private String description;
        private BigDecimal percentage;
        private Date percentageAsOfDate;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder pensionCode(String value){
            this.pensionCode = value;
            return this;
        }
        public Builder description(String value){
            this.description = value;
            return this;
        }
        public Builder percentage(BigDecimal value){
            this.percentage = value;
            return this;
        }
        public Builder percentageAsOfDate(Date value){
            this.percentageAsOfDate = value;
            return this;
        }


        public Builder copy(PensionFund value) {
            this.id = value.id;
            this.pensionCode = value.pensionCode;
            this.description = value.description;
            this.percentage = value.percentage;
            this.percentageAsOfDate = value.percentageAsOfDate;
            return this;
        }
        public PensionFund build() {
            return new PensionFund(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PensionFund)) return false;

        PensionFund that = (PensionFund) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getPensionCode() != null ? !getPensionCode().equals(that.getPensionCode()) : that.getPensionCode() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        if (getPercentage() != null ? !getPercentage().equals(that.getPercentage()) : that.getPercentage() != null)
            return false;
        return !(getPercentageAsOfDate() != null ? !getPercentageAsOfDate().equals(that.getPercentageAsOfDate()) : that.getPercentageAsOfDate() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPensionCode() != null ? getPensionCode().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getPercentage() != null ? getPercentage().hashCode() : 0);
        result = 31 * result + (getPercentageAsOfDate() != null ? getPercentageAsOfDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PensionFund{" +
                "id=" + id +
                ", pensionCode='" + pensionCode + '\'' +
                ", description='" + description + '\'' +
                ", percentage=" + percentage +
                ", percentageAsOfDate=" + percentageAsOfDate +
                '}';
    }
}
