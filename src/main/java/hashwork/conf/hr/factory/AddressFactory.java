/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.conf.hr.factory;

import hashwork.domain.hr.Address;
import java.util.Map;

/**
 *
 * @author Garran
 */
public class AddressFactory {
            public static Address createAddress(
                        Map<String,String> values){
        Address address = new Address
                .Builder(values.get("PostalCode"))
                .suburb(values.get("suburb"))
                .streetName(values.get("streetName"))
                .Number(values.get("Number"))
                .build();
        return address;
    }
}
