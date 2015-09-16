package hashwork.domain.payroll.ui.deductions;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class AllowanceTypeList implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String allowanceType;
    private String description;
    private BigDecimal maxAmount;

    public String getId() {
        return id;
    }

    public String getAllowanceType() {
        return allowanceType;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    private AllowanceTypeList() {

    }

    private AllowanceTypeList(Builder builder) {
        this.id = builder.id;
        this.allowanceType = builder.allowanceType;
        this.description = builder.description;
        this.maxAmount = builder.maxAmount;

    }

    public static class Builder {
        private String id;
        private String allowanceType;
        private String description;
        private BigDecimal maxAmount;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder allowanceType(String value) {
            this.allowanceType = value;
            return this;
        }

        public Builder description(String value) {
            this.description = value;
            return this;
        }

        public Builder maxAmount(BigDecimal value) {
            this.maxAmount = value;
            return this;
        }

        public Builder copy(AllowanceTypeList value) {
            this.id = value.id;
            this.allowanceType = value.allowanceType;
            this.description = value.description;
            this.maxAmount = value.maxAmount;
            return this;
        }

        public AllowanceTypeList build() {
            return new AllowanceTypeList(this);
        }
    }

    @Override
    public String toString() {
        return "AllowanceTypeList{" +
                "id=" + id +
                ", allowanceType='" + allowanceType + '\'' +
                ", description='" + description + '\'' +
                ", maxAmount=" + maxAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AllowanceTypeList)) return false;

        AllowanceTypeList that = (AllowanceTypeList) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getAllowanceType() != null ? !getAllowanceType().equals(that.getAllowanceType()) : that.getAllowanceType() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        return !(getMaxAmount() != null ? !getMaxAmount().equals(that.getMaxAmount()) : that.getMaxAmount() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAllowanceType() != null ? getAllowanceType().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getMaxAmount() != null ? getMaxAmount().hashCode() : 0);
        return result;
    }
}
