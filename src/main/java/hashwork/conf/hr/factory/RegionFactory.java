/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.conf.hr.factory;

import hashwork.domain.hr.City;
import hashwork.domain.hr.Region;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Garran
 */
public class RegionFactory {
    public static Region createRegion(
                        Map<String,String> values,
                        List<City> city){
        Region region = new Region
                .Builder(values.get("region"))
                .city(city)
                .build();
        return region;
    }
}
