/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.domain.hr;

import hashwork.conf.hr.factory.DepartmentFactory;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Garran
 */
public class DepartmentTest {
    
    public DepartmentTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
        
        Map<String,String> values = new HashMap<String,String>();
        values.put("departmentName","department1");
        
        Department department = DepartmentFactory
                .createDepartment(values,null);
        Assert.assertEquals("department1",department.getDepartmentName());
    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,String> values = new HashMap<String,String>();
        values.put("departmentName","department1");
        
        Department department = DepartmentFactory
                .createDepartment(values,null);

        Department copiedDepartment = new Department
                .Builder("department1").copy(department).build();
        Assert.assertEquals("department1",department.getDepartmentName());
        Assert.assertEquals("department1",copiedDepartment.getDepartmentName());
    }
}
