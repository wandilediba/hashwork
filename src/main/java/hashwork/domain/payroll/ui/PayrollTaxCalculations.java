package hashwork.domain.payroll.ui;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PayrollTaxCalculations implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String taxCodesId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getTaxCodesId() {
        return taxCodesId;
    }

    private PayrollTaxCalculations() {
    }

    public PayrollTaxCalculations(Builder builder) {
        this.id = builder.id;
        this.taxCodesId = builder.taxCodesId;
    }

    public static class Builder {
        private String id;
        private String taxCodesId;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder taxCodesId(String value) {
            this.taxCodesId = value;
            return this;
        }

        public Builder copy(PayrollTaxCalculations value) {
            this.id = value.id;
            this.taxCodesId = value.taxCodesId;
            return this;
        }

        public PayrollTaxCalculations build() {
            return new PayrollTaxCalculations(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PayrollTaxCalculations)) return false;

        PayrollTaxCalculations that = (PayrollTaxCalculations) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return !(taxCodesId != null ? !taxCodesId.equals(that.taxCodesId) : that.taxCodesId != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (taxCodesId != null ? taxCodesId.hashCode() : 0);
        return result;
    }
}
