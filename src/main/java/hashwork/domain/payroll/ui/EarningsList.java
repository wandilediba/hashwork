package hashwork.domain.payroll.ui;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EarningsList implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String earningsType;
    private String earningsDesc;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getEarningsType() {
        return earningsType;
    }

    public String getEarningsDesc() {
        return earningsDesc;
    }

    private EarningsList() {
    }

    private EarningsList(Builder builder) {
        this.id = builder.id;
        this.earningsType = builder.earningsType;
        this.earningsDesc = builder.earningsDesc;
    }

    public static class Builder {
        private String id;
        private String earningsType;
        private String earningsDesc;

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder earningsType(String value) {
            this.earningsType = value;
            return this;
        }

        public Builder earningsDesc(String value) {
            this.earningsDesc = value;
            return this;
        }

        public Builder copy(EarningsList value) {
            this.id = value.id;
            this.earningsType = value.earningsType;
            this.earningsDesc = value.earningsDesc;
            this.earningsType = value.earningsType;
            return this;
        }

        public EarningsList build() {
            return new EarningsList(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EarningsList)) return false;

        EarningsList that = (EarningsList) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (earningsType != null ? !earningsType.equals(that.earningsType) : that.earningsType != null) return false;
        return !(earningsDesc != null ? !earningsDesc.equals(that.earningsDesc) : that.earningsDesc != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (earningsType != null ? earningsType.hashCode() : 0);
        result = 31 * result + (earningsDesc != null ? earningsDesc.hashCode() : 0);
        return result;
    }
}
