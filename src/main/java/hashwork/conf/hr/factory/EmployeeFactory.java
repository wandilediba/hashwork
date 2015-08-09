/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.conf.hr.factory;

import hashwork.domain.hr.Address;
import hashwork.domain.hr.Contact;
import hashwork.domain.hr.Employee;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Garran
 */
public class EmployeeFactory {
    public static Employee createEmployee(
                        Date hireDate,
                        Contact contact,
                        Address address,
                        Map<String,String> values){
        Employee employee = new Employee
                .Builder(values.get("employeeNumber"))
                .name(values.get("name"))
                .surname(values.get("surname"))
                .identificationNumber(values.get("identificationNumber"))
                .hireDate(hireDate)
                .employeeType(values.get("employeeType"))
                .contact(contact)
                .address(address)
                .build();
        return employee;
    }
}
