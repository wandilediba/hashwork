package hashwork.client.content.system.positions.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/09/16.
 */
public class PositionSalarySourceModel implements Serializable {

    private String positionId;
    private String funderId;
    private BigDecimal amount;
    private String currencyId;

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getFunderId() {
        return funderId;
    }

    public void setFunderId(String funderId) {
        this.funderId = funderId;
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
