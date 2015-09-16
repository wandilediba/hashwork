package hashwork.client.content.system.jobs.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/09/16.
 */
public class BenefitTypeModel implements Serializable {

    //Allowance, Travel Advance and Bonus.
    private String benefitTypeName;
    private BigDecimal amount;
    private String currencyId;

    public String getBenefitTypeName() {
        return benefitTypeName;
    }

    public void setBenefitTypeName(String benefitTypeName) {
        this.benefitTypeName = benefitTypeName;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
