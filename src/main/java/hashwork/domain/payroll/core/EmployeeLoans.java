package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeLoans implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String personId;
    private BigDecimal loanAmount;
    private BigDecimal loanInstalment;
    private BigDecimal interestRatePerMonth;
    private Date loanCommenceDate;
    private Date loanExpectedEndDate;
    private BigDecimal balance;
    private String loanType;
    private Date lastPaymentDate;

    private EmployeeLoans() {
    }

    private EmployeeLoans(Builder builder){
        this.id = builder.id;
        this.personId = builder.personId;
        this.loanAmount = builder.loanAmount;
        this.loanInstalment = builder.loanInstalment;
        this.interestRatePerMonth = builder.interestRatePerMonth;
        this.loanCommenceDate = builder.loanCommenceDate;
        this.loanExpectedEndDate = builder.loanExpectedEndDate;
        this.balance = builder.balance;
        this.loanType = builder.loanType;
        this.lastPaymentDate = builder.lastPaymentDate;
    }

    public static class Builder{

        private String id;
        private String personId;
        private BigDecimal loanAmount;
        private BigDecimal loanInstalment;
        private BigDecimal interestRatePerMonth;
        private Date loanCommenceDate;
        private Date loanExpectedEndDate;
        private BigDecimal balance;
        private String loanType;
        private Date lastPaymentDate;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.personId = value;
            return this;
        }

        public Builder loanAmount(BigDecimal value){
            this.loanAmount = value;
            return this;
        }

        public Builder loanInstalment(BigDecimal value){
            this.loanInstalment = value;
            return this;
        }

        public Builder interestRatePerMonth(BigDecimal value){
            this.interestRatePerMonth = value;
            return this;
        }

        public Builder loanCommenceDate(Date value){
            this.loanCommenceDate = value;
            return this;
        }
        public Builder loanExpectedEndDate(Date value){
            this.loanExpectedEndDate = value;
            return this;
        }

        public Builder balance(BigDecimal value){
            this.balance = value;
            return this;
        }
        public Builder loanType(String value){
            this.loanType = value;
            return this;
        }
        public Builder lastPaymentDate(Date value){
            this.lastPaymentDate = value;
            return this;
        }
        public Builder copy(EmployeeLoans value) {
            this.id = value.id;
            this.personId = value.personId;
            this.loanAmount = value.loanAmount;
            this.loanInstalment = value.loanInstalment;
            this.interestRatePerMonth = value.interestRatePerMonth;
            this.loanCommenceDate = value.loanCommenceDate;
            this.loanExpectedEndDate = value.loanExpectedEndDate;
            this.balance = value.balance;
            this.loanType = value.loanType;
            this.lastPaymentDate = value.lastPaymentDate;
            return this;
        }

        public EmployeeLoans build() {
            return new EmployeeLoans(this);
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeLoans)) return false;

        EmployeeLoans that = (EmployeeLoans) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;
        if (loanAmount != null ? !loanAmount.equals(that.loanAmount) : that.loanAmount != null) return false;
        if (loanInstalment != null ? !loanInstalment.equals(that.loanInstalment) : that.loanInstalment != null)
            return false;
        if (interestRatePerMonth != null ? !interestRatePerMonth.equals(that.interestRatePerMonth) : that.interestRatePerMonth != null)
            return false;
        if (loanCommenceDate != null ? !loanCommenceDate.equals(that.loanCommenceDate) : that.loanCommenceDate != null)
            return false;
        if (loanExpectedEndDate != null ? !loanExpectedEndDate.equals(that.loanExpectedEndDate) : that.loanExpectedEndDate != null)
            return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (loanType != null ? !loanType.equals(that.loanType) : that.loanType != null) return false;
        return !(lastPaymentDate != null ? !lastPaymentDate.equals(that.lastPaymentDate) : that.lastPaymentDate != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (loanAmount != null ? loanAmount.hashCode() : 0);
        result = 31 * result + (loanInstalment != null ? loanInstalment.hashCode() : 0);
        result = 31 * result + (interestRatePerMonth != null ? interestRatePerMonth.hashCode() : 0);
        result = 31 * result + (loanCommenceDate != null ? loanCommenceDate.hashCode() : 0);
        result = 31 * result + (loanExpectedEndDate != null ? loanExpectedEndDate.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (loanType != null ? loanType.hashCode() : 0);
        result = 31 * result + (lastPaymentDate != null ? lastPaymentDate.hashCode() : 0);
        return result;
    }
}
