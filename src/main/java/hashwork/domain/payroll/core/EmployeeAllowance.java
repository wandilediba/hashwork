package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeeAllowance implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String personId;
    private String allowanceType;
    private BigDecimal amount;
    private Date validAsFrom;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getAllowanceType() {
        return allowanceType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getValidAsFrom() {
        return validAsFrom;
    }

    private EmployeeAllowance() {
    }

    private EmployeeAllowance(Builder builder) {
        this.id = builder.id;
        this.personId = builder.personId;
        this.allowanceType = builder.allowanceType;
        this.amount = builder.amount;
        this.validAsFrom = builder.validAsFrom;
    }

    public static class Builder{
        private String id;
        private String personId;
        private String allowanceType;
        private BigDecimal amount;
        private Date validAsFrom;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.personId = value;
            return this;
        }

        public Builder allowanceType(String value){
            this.allowanceType = value;
            return this;
        }

        public Builder amount(BigDecimal value) {
            this.amount = value;
            return this;
        }

        public Builder validAsFrom(Date value){
            this.validAsFrom = value;
            return this;
        }

        public Builder copy(EmployeeAllowance value) {
            this.id = value.id;
            this.personId = value.personId;
            this.allowanceType = value.allowanceType;
            this.validAsFrom = value.validAsFrom;
            this.amount = value.amount;
            return this;
        }

        public EmployeeAllowance build() {
            return new EmployeeAllowance(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeAllowance)) return false;

        EmployeeAllowance that = (EmployeeAllowance) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;
        if (allowanceType != null ? !allowanceType.equals(that.allowanceType) : that.allowanceType != null)
            return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        return !(validAsFrom != null ? !validAsFrom.equals(that.validAsFrom) : that.validAsFrom != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (allowanceType != null ? allowanceType.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (validAsFrom != null ? validAsFrom.hashCode() : 0);
        return result;
    }
}
