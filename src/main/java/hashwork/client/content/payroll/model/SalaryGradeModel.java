package hashwork.client.content.payroll.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zamzam on 15/09/22.
 */
public class SalaryGradeModel implements Serializable {
    private String gradeName;
    private String notes;
    private BigDecimal midAmount;
    private BigDecimal endAmount;
    private BigDecimal startAmount;
    private BigDecimal currentAmount;
    private String currencyId;

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BigDecimal getMidAmount() {
        return midAmount;
    }

    public void setMidAmount(BigDecimal midAmount) {
        this.midAmount = midAmount;
    }

    public BigDecimal getEndAmount() {
        return endAmount;
    }

    public void setEndAmount(BigDecimal endAmount) {
        this.endAmount = endAmount;
    }

    public BigDecimal getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(BigDecimal startAmount) {
        this.startAmount = startAmount;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }
}
