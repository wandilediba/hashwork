package hashwork.domain.payroll.ui.deductions;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class UIFContributionList implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String code;
    private BigDecimal uifPercentContribution;

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getUifPercentContribution() {
        return uifPercentContribution;
    }
    private UIFContributionList(){

    }
    private UIFContributionList(Builder builder){
        this.id = builder.id;
        this.code = builder.code;
        this.uifPercentContribution = builder.uifPercentContribution;
    }

    public static class Builder{
        private String id;
        private String code;
        private BigDecimal uifPercentContribution;

        public Builder id(String value){
            this.id = value;
            return this;
        }
        public Builder code(String value){
            this.code = value;
            return this;
        }
        public Builder uifPercentContribution(BigDecimal value){
            this.uifPercentContribution = value;
            return this;
        }

        public Builder copy(UIFContributionList value) {
            this.id = value.id;
            this.code = value.code;
            this.uifPercentContribution = value.uifPercentContribution;
            return this;
        }
        public UIFContributionList build() {
            return new UIFContributionList(this);
        }
    }

    @Override
    public String toString() {
        return "UIFContributionList{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", uifPercentContribution=" + uifPercentContribution +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UIFContributionList)) return false;

        UIFContributionList that = (UIFContributionList) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getCode() != null ? !getCode().equals(that.getCode()) : that.getCode() != null) return false;
        return !(getUifPercentContribution() != null ? !getUifPercentContribution().equals(that.getUifPercentContribution()) : that.getUifPercentContribution() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
        result = 31 * result + (getUifPercentContribution() != null ? getUifPercentContribution().hashCode() : 0);
        return result;
    }
}
