/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.conf.hr.factory;

import hashwork.domain.hr.Country;
import hashwork.domain.hr.Region;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Garran
 */
public class CountryFactory {
    public static Country createCountry(
                        Map<String,String> values,
                        List<Region> region){
        Country country = new Country
                .Builder(values.get("region"))
                .region(region)
                .build();
        return country;
    }
}
