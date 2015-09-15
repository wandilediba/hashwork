package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeePayslip implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String personId;
    private BigDecimal netPay;
    private Date payslipGenerateDate;

    private EmployeePayslip() {
    }

    private EmployeePayslip(Builder builder) {
        this.id = builder.id;
        this.personId = builder.personId;
        this.netPay = builder.netPay;
        this.payslipGenerateDate = builder.payslipGenerateDate;
    }

    public static class Builder{
        private String id;
        private String personId;
        private BigDecimal netPay;
        private Date payslipGenerateDate;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.personId = value;
            return this;
        }

        public Builder netPay(BigDecimal value){
            this.netPay = value;
            return this;
        }

        public Builder payslipGenerateDate(Date value){
            this.payslipGenerateDate = value;
            return this;
        }

        public Builder copy(EmployeePayslip value) {
            this.id = value.id;
            this.personId = value.personId;
            this.netPay = value.netPay;
            this.payslipGenerateDate = value.payslipGenerateDate;
            return this;
        }

        public EmployeePayslip build(){
            return new EmployeePayslip(this);
        }

    }
}
