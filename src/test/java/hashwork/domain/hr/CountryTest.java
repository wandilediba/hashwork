/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.domain.hr;

import hashwork.conf.hr.factory.CountryFactory;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Garran
 */
public class CountryTest {
    
    public CountryTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
        
        Map<String,String> values = new HashMap<String,String>();
        values.put("country","South Africa");
        
        Country country = CountryFactory
                .createCountry(values,null);
        Assert.assertEquals("South Africa",country.getCountry());
    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,String> values = new HashMap<String,String>();
        values.put("country","South Africa");
        
        Country country = CountryFactory
                .createCountry(values,null);

        Country copiedCountry = new Country
                .Builder("South Africa").copy(country).build();
        Assert.assertEquals("South Africa",country.getCountry());
        Assert.assertEquals("South Africa",copiedCountry.getCountry());
    }
}
