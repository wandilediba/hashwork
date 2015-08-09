/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.domain.hr;

import hashwork.conf.hr.factory.RegionFactory;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Garran
 */
public class RegionTest {
    
    public RegionTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
        
        Map<String,String> values = new HashMap<String,String>();
        values.put("region","Western Cape");
        
        Region region = RegionFactory
                .createRegion(values,null);
        Assert.assertEquals("Western Cape",region.getRegion());
    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,String> values = new HashMap<String,String>();
        values.put("region","Western Cape");
        
        Region region = RegionFactory
                .createRegion(values,null);

        Region copiedRegion = new Region
                .Builder("Western Cape").copy(region).build();
        Assert.assertEquals("Western Cape",region.getRegion());
        Assert.assertEquals("Western Cape",copiedRegion.getRegion());
    }
}
