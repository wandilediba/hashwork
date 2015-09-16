/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonBenefitsFundingSource;
import java.math.BigDecimal;

/**
 *
 * @author BONGANI
 */
public class PersonBenefitsSourceFactory {
    
    public static PersonBenefitsFundingSource getPersonBenefitsFundingSource (String personId,String funderId,BigDecimal amount,String currencyId)
    {
        PersonBenefitsFundingSource personBenefitsFundingSource = new PersonBenefitsFundingSource.Builder()
                .id(KeyGenerator.getEntityId())
                .personId(personId)
                .currencyId(currencyId)
                .funderId(funderId)
                .amount(amount)
                .build();
                
      return personBenefitsFundingSource;
    
    }
    
}


 