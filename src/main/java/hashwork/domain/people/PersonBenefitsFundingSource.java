package hashwork.domain.people;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by bongani on 2015/08/22.
 */
public class PersonBenefitsFundingSource implements Serializable {
    private String id;
    private String personId;
    private String funderId;
    private BigDecimal amount;
    private String currencyId;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
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
    
     private  PersonBenefitsFundingSource(){}

    public PersonBenefitsFundingSource(Builder builder){
        this.id =  builder.id;
        this.personId = builder.personId;
        this.funderId = builder.funderId;
        this.amount = builder.amount;
        this.currencyId = builder.currencyId;
    }

    public static class Builder{

        private String id;
        private String personId;
        private String funderId;
        private BigDecimal amount;
        private String currencyId;

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder personId(String value){
            this.id = value;
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

        public Builder copy(PersonBenefitsFundingSource value){
            this.id =  value.id;
            this.personId = value.personId;
            this.amount = value.amount;
            this.currencyId = value.currencyId;

            return this;

        }

        public PersonBenefitsFundingSource build(){
            return new PersonBenefitsFundingSource(this);
        }

    }

    public static Builder builder() {
        return new Builder();
    }
    
}

   