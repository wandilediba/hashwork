/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.domain.hr;

import hashwork.conf.hr.factory.CityFactory;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 *
 * @author Garran
 */
public class CityTest {
    
    public CityTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
        
        Map<String,String> values = new HashMap<String,String>();
        values.put("city","Cape Town");
        
        City city = CityFactory
                .createCity(values);
        Assert.assertEquals("Cape Town",city.getCity());
    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,String> values = new HashMap<String,String>();
        values.put("city","Cape Town");
        
        City city = CityFactory
                .createCity(values);
        Assert.assertEquals("Cape Town",city.getCity());

        City copiedCity = new City
                .Builder("Cape Town").copy(city).build();
        Assert.assertEquals("Cape Town",city.getCity());
        Assert.assertEquals("Cape Town",copiedCity.getCity());
    }
}
