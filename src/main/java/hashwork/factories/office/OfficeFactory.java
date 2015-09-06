/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.office;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.office.Office;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author BONGANI
 */
public class OfficeFactory {
    public static Office getOffice(String id, String name, String description, String active, Date dateEstablished, String cityId, String officeTypeId, String contactId, Set<String> positionIds) {
        Office office = new Office
                 .Builder()
                .id(id)
                .name(name)
                .active(active)
                .description(description)
                .cityId(cityId)
                .contactId(contactId)
                .officeTypeId(officeTypeId)
                .positionIds(positionIds)
                .dateEstablished(dateEstablished)
                .id(KeyGenerator.getEntityId())
                .build();
        return office;
    }
    
}


