/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonEmploymentHistory;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author BONGANI
 */
public class PersonEmploymentHistoryFactory {
 public static PersonEmploymentHistory getPersonEmployement (String personId,
                                                             String companyName,
                                                             String companyAddress,
                                                             String companyTelephone,
                                                             String applicatSupervisor,
                                                             Boolean contactSupervisor,
                                                             String reasonsForLeaving,
                                                             Date startDate,
                                                             Date endDate,
                                                             BigDecimal startingSalary,
                                                             BigDecimal endingSalary,
                                                             String currencyId,
                                                             String jobResponsibility,
                                                             String jobId)
    {
        PersonEmploymentHistory personEmploymentHistory = new PersonEmploymentHistory.Builder()
                .id(KeyGenerator.getEntityId())
                .applicatSupervisor(applicatSupervisor)
                .companyAddress(companyAddress)
                .companyName(companyName)
                .companyTelephone(companyTelephone)
                .contactSupervisor(contactSupervisor)
                .currencyId(currencyId)
                .endDate(endDate)
                .endingSalary(endingSalary)
                .jobId(jobId)
                .jobResponsibility(jobResponsibility)
                .personId(personId)
                .jobResponsibility(jobResponsibility)                
                .build();
                
      return personEmploymentHistory;
    
    }   
}


  