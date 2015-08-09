/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.conf.hr.factory;

import hashwork.domain.hr.Country;
import hashwork.domain.hr.Department;
import java.util.Map;

/**
 *
 * @author Garran
 */
public class DepartmentFactory {
    public static Department createDepartment(
                        Map<String,String> values,
                        Country country){
        Department department = new Department
                .Builder(values.get("departmentName"))
                .country(country)
                .build();
        return department;
    }
}
