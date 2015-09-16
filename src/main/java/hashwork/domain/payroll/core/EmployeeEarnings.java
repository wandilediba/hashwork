package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeEarnings implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String personId;
    private BigDecimal earningsAmt;
    private String earningsTypeDesc;
    private String earningsCode;
    private Date payDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public BigDecimal getEarningsAmt() {
        return earningsAmt;
    }

    public String getEarningsTypeDesc() {
        return earningsTypeDesc;
    }

    public String getEarningsCode() {
        return earningsCode;
    }

    public Date getPayDate() {
        return payDate;
    }

    private EmployeeEarnings() {
    }

    private EmployeeEarnings(Builder builder) {
        this.id = builder.id;
        this.personId = builder.personId;
        this.earningsAmt = builder.earningsAmt;
        this.earningsTypeDesc = builder.earningsTypeDesc;
        this.earningsCode = builder.earningsCode;
        this.payDate = builder.payDate;
    }

    public static class Builder{
        private String id;
        private String personId;
        private BigDecimal earningsAmt;
        private String earningsTypeDesc;
        private String earningsCode;
        private Date payDate;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.personId = value;
            return this;
        }

        public Builder earningsAmt(BigDecimal value){
            this.earningsAmt = value;
            return this;
        }

        public Builder earningsTypeDesc(String value) {
            this.earningsTypeDesc = value;
            return this;
        }

        public Builder earningsCode(String value){
            this.earningsCode = value;
            return this;
        }

        public Builder payDate(Date value){
            this.payDate = value;
            return this;
        }


        public EmployeeEarnings build() {
            return new EmployeeEarnings(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeEarnings)) return false;

        EmployeeEarnings that = (EmployeeEarnings) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;
        if (earningsAmt != null ? !earningsAmt.equals(that.earningsAmt) : that.earningsAmt != null) return false;
        if (earningsTypeDesc != null ? !earningsTypeDesc.equals(that.earningsTypeDesc) : that.earningsTypeDesc != null)
            return false;
        if (earningsCode != null ? !earningsCode.equals(that.earningsCode) : that.earningsCode != null) return false;
        return !(payDate != null ? !payDate.equals(that.payDate) : that.payDate != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (earningsAmt != null ? earningsAmt.hashCode() : 0);
        result = 31 * result + (earningsTypeDesc != null ? earningsTypeDesc.hashCode() : 0);
        result = 31 * result + (earningsCode != null ? earningsCode.hashCode() : 0);
        result = 31 * result + (payDate != null ? payDate.hashCode() : 0);
        return result;
    }
}
