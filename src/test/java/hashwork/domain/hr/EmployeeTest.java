/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.domain.hr;

import hashwork.conf.hr.factory.EmployeeFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.print.attribute.standard.DateTimeAtCompleted;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Garran
 */
public class EmployeeTest {
    
    public EmployeeTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
        
        Map<String,String> values = new HashMap<String,String>();
        values.put("employeeNumber","001");
        values.put("name","Garran");
        values.put("surname","Michaels");
        values.put("identificationNumber","9102035432454");
        values.put("employeeType","department1");
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = formatter.parse("01/02/1991");
        
        Employee employee = EmployeeFactory
                .createEmployee(date,null,null,values);
        Assert.assertEquals("001",employee.getEmployeeNumber());
    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,String> values = new HashMap<String,String>();
        values.put("employeeNumber","001");
        values.put("name","Garran");
        values.put("surname","Michaels");
        values.put("identificationNumber","9102035432454");
        values.put("employeeType","department1");
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = formatter.parse("01/02/1991");
        
        Employee employee = EmployeeFactory
                .createEmployee(date,null,null,values);

        Employee copiedEmployee = new Employee
                .Builder("001").copy(employee).build();
        Assert.assertEquals("001",employee.getEmployeeNumber());
        Assert.assertEquals("001",copiedEmployee.getEmployeeNumber());
    }
}
