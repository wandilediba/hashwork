package hashwork.factories.ui.employee;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.employee.HireDate;

/**
 * Created by garran on 2015/09/06.
 */
public class HireDateFactory {
    public static HireDate getSuburb(String value) {
        HireDate hireDate = new HireDate.Builder()
                .id(KeyGenerator.getEntityId())
                .hiteDate(value).build();
        return hireDate;
    }
}
