package hashwork.factories.ui.location;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.location.RegistrationBody;

import java.util.Date;

/**
 * Created by garran on 2015/09/06.
 */
public class RegistrationBodyFactory {
    public static RegistrationBody getRegistrationBody(String name,
                                                       String description,
                                                       String coreActivity,
                                                       String active,
                                                       Date asOfDate) {
        RegistrationBody registrationBody = new RegistrationBody.Builder()
                .id(KeyGenerator.getEntityId())
                .name(name)
                .description(description)
                .coreActivity(coreActivity)
                .active(active)
                .asOfDate(asOfDate)
                .build();
        return registrationBody;
    }
}
