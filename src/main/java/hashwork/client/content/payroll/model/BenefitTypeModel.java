package hashwork.client.content.payroll.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zamzam on 15/09/21.
 */
public class BenefitTypeModel implements Serializable {
    private String benefitTypeName;
    private BigDecimal amount;
    private String currencyId;

    public String getBenefitTypeName() {
        return benefitTypeName;
    }

    public void setBenefitTypeName(String benefitTypeName) {
        this.benefitTypeName = benefitTypeName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }
}
