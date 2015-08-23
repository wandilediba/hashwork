package hashwork.domain.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Bongani on 2015/08/22.
 */
public class PersonBenefits implements Serializable {
    private String id;
    private String personId;
    private String benefitTypeId;
    private List<String> PersonBenefitsFundingSourceIds;
    private String currencyId;
    private Date startDate;
    private Date endDate;
    private String benefitFrequencyId;
    private BigDecimal amount;

    public String getId() {
        return id;
    }

    public String getPersonId() {
        return personId;
    }

    public String getBenefitTypeId() {
        return benefitTypeId;
    }

    public List<String> getPersonBenefitsFundingSourceIds() {
        return PersonBenefitsFundingSourceIds;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getBenefitFrequencyId() {
        return benefitFrequencyId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    
    public PersonBenefits() { }
    
    public PersonBenefits (Builder builder){

        this.id = builder.id;
        this.personId = builder.personId;
        this.benefitTypeId = builder.benefitTypeId;
        this.currencyId = builder.currencyId;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.benefitFrequencyId = builder.benefitFrequencyId;
        this.PersonBenefitsFundingSourceIds = builder.PersonBenefitsFundingSourceIds;
        this.amount = builder.amount;
        
    }
    
    public static class Builder{

        private String id;
        private String personId;
        private String benefitTypeId;
        private List<String> PersonBenefitsFundingSourceIds;
        private String currencyId;
        private Date startDate;
        private Date endDate;
        private String benefitFrequencyId;
        private BigDecimal amount;
        
        public Builder id(String value){
            this.id = value;
            return this;
        }
        
        public Builder personId(String value){
            this.personId = value;
            return this;
        }
        
         public Builder PersonBenefitsFundingSourceIds(List<String> value){
            this.PersonBenefitsFundingSourceIds = value;
            return this;
        }
         
         public PersonBenefits.Builder benefitTypeId(String value){
            this.benefitTypeId = value;
            return this;
        }
         public PersonBenefits.Builder currencyId(String value){
            this.currencyId = value;
            return this;
        }
         
         public PersonBenefits.Builder startDate(Date value){
            this.startDate = value;
            return this;
        }
         public PersonBenefits.Builder endDate(Date value){
            this.endDate = value;
            return this;
        }
        
        public PersonBenefits.Builder benefitFrequencyId(String value){
            this.benefitFrequencyId = value;
            return this;
        }
        public PersonBenefits.Builder amount(BigDecimal value){
            this.amount = value;
            return this;
        }
        
          public Builder copy(PersonBenefits value){

            this.id =  value.id;
            this.id = value.id;
            this.personId = value.personId;
            this.benefitTypeId = value.benefitTypeId;
            this.currencyId = value.currencyId;
            this.startDate = value.startDate;
            this.endDate = value.endDate;
            this.benefitFrequencyId = value.benefitFrequencyId;
            this.PersonBenefitsFundingSourceIds = value.PersonBenefitsFundingSourceIds;
            this.amount = value.amount;
            return this;
         }
    
    }
    
      public static Builder builder() {
        return new Builder();
    }
}
