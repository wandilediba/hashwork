/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.office;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.office.OfficeType;

/**
 * @author BONGANI
 */
public class OfficeTypeFactory {

    public static OfficeType getOfficeType(String id, String name) {
        OfficeType officeType = new OfficeType
                .Builder()
                .id(id)
                .name(name)
                .id(KeyGenerator.getEntityId())
                .build();
        return officeType;
    }

}
