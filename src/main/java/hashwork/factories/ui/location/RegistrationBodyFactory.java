package hashwork.factories.ui.location;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.location.RegistrationBody;

import java.util.Date;
import java.util.Map;

/**
 * Created by zamzam on 15/09/06.
 */
public class RegistrationBodyFactory {
    public static RegistrationBody getRegistrationBody(Map<String, String> values,
                                                       Date asOfDate){
        RegistrationBody registrationBody = new RegistrationBody
                .Builder()
                .id(KeyGenerator.getEntityId())
                .name(values.get("name"))
                .description(values.get("desc"))
                .coreActivity(values.get("coreActivity"))
                .active(values.get("active"))
                .asOfDate(asOfDate).build();
        return registrationBody;
    }
}
