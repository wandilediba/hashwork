/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.factories.office;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.office.Company;


/**
 * @author BONGANI
 */
public class CompanyFactory {
    public static Company getCompany(String id, String name) {
        Company company = new Company
                .Builder()
                .id(id)
                .name(name)
                .id(KeyGenerator.getEntityId())
                .build();
        return company;
    }

}





  