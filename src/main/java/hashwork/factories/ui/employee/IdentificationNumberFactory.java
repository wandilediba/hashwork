package hashwork.factories.ui.employee;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.employee.IdentificationNumber;

/**
 * Created by garran on 2015/09/06.
 */
public class IdentificationNumberFactory {
    public static IdentificationNumber getSuburb(String value) {
        IdentificationNumber identificationNumber = new IdentificationNumber.Builder()
                .id(KeyGenerator.getEntityId())
                .identificationNumber(value).build();
        return identificationNumber;
    }
}
