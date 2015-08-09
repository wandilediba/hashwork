/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.domain.hr;

import hashwork.conf.hr.factory.AddressFactory;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Garran
 */
public class AddressTest {
    
    public AddressTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
        
        Map<String,String> values = new HashMap<String,String>();
        values.put("suburb","Muizenberg");
        values.put("streetName","Ventnor");
        values.put("Number","1");
        values.put("PostalCode","7945");
        
        Address address = AddressFactory
                .createAddress(values);
        Assert.assertEquals("Muizenberg",address.getSuburb());
    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,String> values = new HashMap<String,String>();
        values.put("suburb","Muizenberg");
        values.put("streetName","Ventnor");
        values.put("Number","1");
        values.put("PostalCode","7945");
        
        Address address = AddressFactory
                .createAddress(values);
        Assert.assertEquals("Muizenberg",address.getSuburb());
        Assert.assertEquals("Ventnor",address.getStreetName());
        Assert.assertEquals("1",address.getNumber());
        Assert.assertEquals("7945",address.getPostalCode());

        Address copiedAddress = new Address
                .Builder("7945").copy(address).build();
        Assert.assertEquals("7945",address.getPostalCode());
        Assert.assertEquals("7945",copiedAddress.getPostalCode());
    }
}
