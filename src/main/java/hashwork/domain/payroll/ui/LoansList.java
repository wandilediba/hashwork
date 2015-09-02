package hashwork.domain.payroll.ui;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class LoansList implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String loanType;
    private String loanDesc;
    private int loanPaybackPeriod;
    private BigDecimal maxLoanAmt;
    private BigDecimal standardInterest;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getLoanDesc() {
        return loanDesc;
    }

    public int getLoanPaybackPeriod() {
        return loanPaybackPeriod;
    }

    public BigDecimal getMaxLoanAmt() {
        return maxLoanAmt;
    }

    public BigDecimal getStandardInterest() {
        return standardInterest;
    }

    private LoansList() {
    }

    public LoansList(Builder builder) {
        this.id = builder.id;
        this.loanType = builder.loanType;
        this.loanDesc = builder.loanDesc;
        this.loanPaybackPeriod = builder.loanPaybackPeriod;
        this.maxLoanAmt = builder.maxLoanAmt;
        this.standardInterest = builder.standardInterest;
    }

    public static class Builder{
        private String id;
        private String loanType;
        private String loanDesc;
        private int loanPaybackPeriod;
        private BigDecimal maxLoanAmt;
        private BigDecimal standardInterest;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder loanType(String value){
            this.loanType = value;
            return this;
        }

        public Builder loanDesc(String value){
            this.loanDesc = value;
            return this;
        }

        public Builder loanPaybackPeriod(int value){
            this.loanPaybackPeriod = value;
            return this;
        }

        public Builder maxLoanAmt(BigDecimal value){
            this.maxLoanAmt = value;
            return this;
        }

        public Builder standardInterest(BigDecimal value){
            this.standardInterest = value;
            return this;
        }

        public Builder copy(LoansList value) {
            this.id = value.id;
            this.standardInterest = value.standardInterest;
            this.loanDesc = value.loanDesc;
            this.loanPaybackPeriod = value.loanPaybackPeriod;
            this.loanType = value.loanType;
            this.maxLoanAmt = value.maxLoanAmt;
            return this;
        }

        public LoansList build(){
            return new LoansList(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoansList)) return false;

        LoansList loansList = (LoansList) o;

        if (loanPaybackPeriod != loansList.loanPaybackPeriod) return false;
        if (id != null ? !id.equals(loansList.id) : loansList.id != null) return false;
        if (loanType != null ? !loanType.equals(loansList.loanType) : loansList.loanType != null) return false;
        if (loanDesc != null ? !loanDesc.equals(loansList.loanDesc) : loansList.loanDesc != null) return false;
        if (maxLoanAmt != null ? !maxLoanAmt.equals(loansList.maxLoanAmt) : loansList.maxLoanAmt != null) return false;
        return !(standardInterest != null ? !standardInterest.equals(loansList.standardInterest) : loansList.standardInterest != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (loanType != null ? loanType.hashCode() : 0);
        result = 31 * result + (loanDesc != null ? loanDesc.hashCode() : 0);
        result = 31 * result + loanPaybackPeriod;
        result = 31 * result + (maxLoanAmt != null ? maxLoanAmt.hashCode() : 0);
        result = 31 * result + (standardInterest != null ? standardInterest.hashCode() : 0);
        return result;
    }
}
