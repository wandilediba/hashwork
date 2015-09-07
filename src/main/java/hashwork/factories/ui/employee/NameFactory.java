package hashwork.factories.ui.employee;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.employee.Name;

/**
 * Created by garran on 2015/09/06.
 */
public class NameFactory {
    public static Name getSuburb(String value) {
        Name name = new Name.Builder()
                .id(KeyGenerator.getEntityId())
                .name(value).build();
        return name;
    }
}
