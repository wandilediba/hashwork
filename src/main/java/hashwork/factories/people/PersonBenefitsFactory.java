/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonBenefits;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author BONGANI
 */
public class PersonBenefitsFactory {
    
     public static PersonBenefits getPersonBenefits (      
                                                    String personId,
                                                    String benefitTypeId,
                                                    List<String> PersonBenefitsFundingSourceIds,
                                                    String currencyId,
                                                    Date startDate,
                                                    Date endDate,
                                                    String benefitFrequencyId,
                                                    BigDecimal amount)
    {
        PersonBenefits personAddress = new PersonBenefits.Builder()
                .id(KeyGenerator.getEntityId())
                .personId(personId)
                .PersonBenefitsFundingSourceIds(PersonBenefitsFundingSourceIds)
                .benefitFrequencyId(benefitFrequencyId)
                .benefitTypeId(benefitTypeId)
                .currencyId(currencyId)
                .amount(amount)
                .startDate(startDate)
                .endDate(endDate)                
                .build();
                
      return personAddress;
    
    }
}


   