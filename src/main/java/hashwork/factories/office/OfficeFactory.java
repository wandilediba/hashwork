/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.office;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.office.Office;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author BONGANI
 */
public class OfficeFactory {
    public static Office getOffice(Map<String,String> values, Date dateEstablished, List<String> positionIds) {
        Office office = new Office
                .Builder()
                .id(KeyGenerator.getEntityId())
                .name(values.get("name"))
                .active(values.get("active"))
                .description(values.get("description"))
                .cityId(values.get("cityId"))
                .contactId(values.get("contactId"))
                .officeTypeId(values.get("officeTypeId"))
                .positionIds(positionIds)
                .dateEstablished(dateEstablished)
                .build();
        return office;
    }

}


