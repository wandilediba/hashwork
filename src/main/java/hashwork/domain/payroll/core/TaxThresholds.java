package hashwork.domain.payroll.core;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by hashcode on 2015/08/17.
 */
public class TaxThresholds implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String personId;
    private BigDecimal taxThreshAmt1;
    private BigDecimal taxThreshAmt2;
    private String taxThreshCategory;
    private String taxThreshDesc;
    private BigDecimal taxPercentage;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public BigDecimal getTaxThreshAmt1() {
        return taxThreshAmt1;
    }

    public BigDecimal getTaxThreshAmt2() {
        return taxThreshAmt2;
    }

    public String getTaxThreshCategory() {
        return taxThreshCategory;
    }

    public String getTaxThreshDesc() {
        return taxThreshDesc;
    }

    public BigDecimal getTaxPercentage() {
        return taxPercentage;
    }

    private TaxThresholds() {
    }

    public TaxThresholds(Builder builder) {
        this.id = builder.id;
        this.personId = builder.personId;
        this.taxThreshAmt1 = builder.taxThreshAmt1;
        this.taxThreshAmt2 = builder.taxThreshAmt2;
        this.taxThreshCategory = builder.taxThreshCategory;
        this.taxThreshDesc = builder.taxThreshDesc;
        this.taxPercentage = builder.taxPercentage;
    }

    public static class Builder{
        private String id;
        private String personId;
        private BigDecimal taxThreshAmt1;
        private BigDecimal taxThreshAmt2;
        private String taxThreshCategory;
        private String taxThreshDesc;
        private BigDecimal taxPercentage;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.personId = value;
            return this;
        }

        public Builder taxThreshAmt1(BigDecimal value){
            this.taxThreshAmt1 = value;
            return this;
        }

        public Builder taxThreshAmt2(BigDecimal value){
            this.taxThreshAmt2 = value;
            return this;
        }

        public Builder taxThreshCategory(String value){
            this.taxThreshCategory = value;
            return this;
        }

        public Builder taxThreshDesc(String value){
            this.taxThreshDesc = value;
            return this;
        }

        public Builder taxPercentage(BigDecimal value){
            this.taxPercentage = value;
            return this;
        }

        public Builder copy(TaxThresholds value) {
            this.id = value.id;
            this.personId = value.personId;
            this.taxThreshAmt1 = value.taxThreshAmt1;
            this.taxThreshAmt2 = value.taxThreshAmt2;
            this.taxThreshDesc = value.taxThreshDesc;
            this.taxThreshCategory = value.taxThreshCategory;
            this.taxPercentage = value.taxPercentage;
            return this;
        }

        public TaxThresholds build(){
            return new TaxThresholds(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaxThresholds)) return false;

        TaxThresholds that = (TaxThresholds) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;
        if (taxThreshAmt1 != null ? !taxThreshAmt1.equals(that.taxThreshAmt1) : that.taxThreshAmt1 != null)
            return false;
        if (taxThreshAmt2 != null ? !taxThreshAmt2.equals(that.taxThreshAmt2) : that.taxThreshAmt2 != null)
            return false;
        if (taxThreshCategory != null ? !taxThreshCategory.equals(that.taxThreshCategory) : that.taxThreshCategory != null)
            return false;
        if (taxThreshDesc != null ? !taxThreshDesc.equals(that.taxThreshDesc) : that.taxThreshDesc != null)
            return false;
        return !(taxPercentage != null ? !taxPercentage.equals(that.taxPercentage) : that.taxPercentage != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (taxThreshAmt1 != null ? taxThreshAmt1.hashCode() : 0);
        result = 31 * result + (taxThreshAmt2 != null ? taxThreshAmt2.hashCode() : 0);
        result = 31 * result + (taxThreshCategory != null ? taxThreshCategory.hashCode() : 0);
        result = 31 * result + (taxThreshDesc != null ? taxThreshDesc.hashCode() : 0);
        result = 31 * result + (taxPercentage != null ? taxPercentage.hashCode() : 0);
        return result;
    }
}
