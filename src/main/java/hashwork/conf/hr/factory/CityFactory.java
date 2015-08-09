/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.conf.hr.factory;

import hashwork.domain.hr.City;
import java.util.Map;

/**
 *
 * @author Garran
 */
public class CityFactory {
        public static City createCity(
                        Map<String,String> values){
        City city = new City
                .Builder(values.get("city"))
                .build();
        return city;
    }
}
