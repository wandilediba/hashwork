package hashwork.client.content.payroll.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zamzam on 2015/10/02.
 */
public class LoansListModel implements Serializable {
    private String loanType;
    private String loanDesc;
    private int loanPaybackPeriod;
    private BigDecimal maxLoanAmt;
    private BigDecimal standardInterest;

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanDesc() {
        return loanDesc;
    }

    public void setLoanDesc(String loanDesc) {
        this.loanDesc = loanDesc;
    }

    public int getLoanPaybackPeriod() {
        return loanPaybackPeriod;
    }

    public void setLoanPaybackPeriod(int loanPaybackPeriod) {
        this.loanPaybackPeriod = loanPaybackPeriod;
    }

    public BigDecimal getMaxLoanAmt() {
        return maxLoanAmt;
    }

    public void setMaxLoanAmt(BigDecimal maxLoanAmt) {
        this.maxLoanAmt = maxLoanAmt;
    }

    public BigDecimal getStandardInterest() {
        return standardInterest;
    }

    public void setStandardInterest(BigDecimal standardInterest) {
        this.standardInterest = standardInterest;
    }
}
