/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.people;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.people.PersonPosition;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author BONGANI
 */
public class PersonPositionFactory {
    public static PersonPosition getPersonPosition ( String personId,
                                                        String positionId,
                                                        Date startDate,
                                                        Date endDate,
                                                        String statusId,
                                                        BigDecimal salary,
                                                        String currencyId,
                                                        Date salaryDate,
                                                        String changeReasonId)
    {
        PersonPosition personPosition = new PersonPosition.Builder()
                .id(KeyGenerator.getEntityId())
                .personId(statusId)
                .positionId(positionId)
                .startDate(startDate)
                .endDate(endDate)
                .statusId(statusId)
                .salary(salary)
                .currencyId(currencyId)
                .salaryDate(salaryDate)
                .changeReasonId(changeReasonId)                              
                .build();
                
      return personPosition;
    
    }
     
}

  