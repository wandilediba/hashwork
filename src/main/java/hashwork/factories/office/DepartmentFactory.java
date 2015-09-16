package hashwork.factories.office;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.office.Department;

import java.util.Date;

/**
 * Created by hashcode on 2015/08/16.
 */
public class DepartmentFactory {
    public static Department getDepartment(String id, String name, Date dateEstablished, boolean active, String description) {
        Department department = new Department
                .Builder()
                .id(id)
                .name(name)
                .dateEstablished(dateEstablished)
                .active(active)
                .description(description)
                .id(KeyGenerator.getEntityId())
                .build();
        return department;
    }

}





