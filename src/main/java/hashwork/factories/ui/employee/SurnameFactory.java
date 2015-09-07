package hashwork.factories.ui.employee;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.employee.Surname;

/**
 * Created by garran on 2015/09/06.
 */
public class SurnameFactory {
    public static Surname getSurname(String value) {
        Surname surname = new Surname.Builder()
                .id(KeyGenerator.getEntityId())
                .surname(value).build();
        return surname;
    }
}
