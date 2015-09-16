package hashwork.domain.payroll.ui.job;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/16.
 */
public class BenefitType implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    //Allowance, Travel Advance and Bonus.
    private String benefitTypeName;
    private BigDecimal amount;
    private String currencyId;
    
    
    public String getId() {
        return id;
    }

    public String getBenefitTypeName() {
        return benefitTypeName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    private BenefitType() {

    }

    private BenefitType(Builder builder) {
        this.id = builder.id;
        this.benefitTypeName = builder.benefitTypeName;
        this.amount = builder.amount;
        this.currencyId = builder.currencyId;

    }

    public static class Builder {
        private String id;
        //Allowance, Travel Advance and Bonus.
        private String benefitTypeName;
        private BigDecimal amount;
        private String currencyId;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder benefitTypeName(String value) {
            this.benefitTypeName = value;
            return this;
        }

        public Builder amount(BigDecimal value) {
            this.amount = value;
            return this;
        }

        public Builder currencyId(String value) {
            this.currencyId = value;
            return this;
        }


        public Builder copy(BenefitType value) {
            this.id = value.id;
            this.benefitTypeName = value.benefitTypeName;
            this.amount = value.amount;
            this.currencyId = value.currencyId;

            return this;
        }

        public BenefitType build() {
            return new BenefitType(this);
        }
    }

    @Override
    public String toString() {
        return "BenefitType{" +
                "id=" + id +
                ", benefitTypeName='" + benefitTypeName + '\'' +
                ", amount='" + amount + '\'' +
                ", currencyId='" + currencyId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BenefitType)) return false;

        BenefitType that = (BenefitType) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getBenefitTypeName() != null ? !getBenefitTypeName().equals(that.getBenefitTypeName()) : that.getBenefitTypeName() != null)
            return false;
        if (getAmount() != null ? !getAmount().equals(that.getAmount()) : that.getAmount() != null) return false;
        return !(getCurrencyId() != null ? !getCurrencyId().equals(that.getCurrencyId()) : that.getCurrencyId() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;       
        result = 31 * result + (getBenefitTypeName() != null ? getBenefitTypeName().hashCode() : 0);
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        result = 31 * result + (getCurrencyId() != null ? getCurrencyId().hashCode() : 0);
        return result;
    }
}


  