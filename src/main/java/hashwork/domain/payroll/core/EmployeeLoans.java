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

    }
}
