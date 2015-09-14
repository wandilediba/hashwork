package hashwork.domain.ui.position;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/16.
 */
public class PositionSalarySource implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String positionId;
    private String funderId;
    private BigDecimal amount;
    private String currencyId;


    public String getId() {
        return id;
    }

    public String getPositionId() {
        return positionId;
    }

    public String getFunderId() {
        return funderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    private PositionSalarySource(Builder builder){
        this.id = builder.id;
        this.amount = builder.amount;
        this.currencyId = builder.currencyId;
        this.funderId = builder.funderId;
        this.positionId = builder.positionId;

    }


    public static class Builder{

        private String id;
        private String positionId;
        private String funderId;
        private BigDecimal amount;
        private String currencyId;

        public Builder id(String value){
            this.id= value;
            return this;
        }

    public Builder positionId(String value){

            this.positionId = value;
        return this;
        }

    public Builder funderId(String value){
        this.funderId = value;
        return this;
    }

    public Builder amount(BigDecimal value){
        this.amount = value;
        return this;

    }

    public Builder currencyId(String value){

        this.currencyId = value;
        return this;
    }

        public Builder copy(PositionSalarySource value) {
            this.id = value.id;
            this.amount = value.amount;
            this.currencyId = value.currencyId;
            this.positionId = value.positionId;
            this.funderId = value.funderId;

            return this;

        }
        public PositionSalarySource build(){
            return new PositionSalarySource(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionSalarySource)) return false;

        PositionSalarySource that = (PositionSalarySource) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getPositionId() != null ? !getPositionId().equals(that.getPositionId()) : that.getPositionId() != null)
            return false;
        if (getFunderId() != null ? !getFunderId().equals(that.getFunderId()) : that.getFunderId() != null)
            return false;
        if (getAmount() != null ? !getAmount().equals(that.getAmount()) : that.getAmount() != null) return false;
        return !(getCurrencyId() != null ? !getCurrencyId().equals(that.getCurrencyId()) : that.getCurrencyId() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPositionId() != null ? getPositionId().hashCode() : 0);
        result = 31 * result + (getFunderId() != null ? getFunderId().hashCode() : 0);
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        result = 31 * result + (getCurrencyId() != null ? getCurrencyId().hashCode() : 0);
        return result;
    }
}
