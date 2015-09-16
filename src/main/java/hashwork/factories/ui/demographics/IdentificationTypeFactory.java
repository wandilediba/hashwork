package hashwork.factories.ui.demographics;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.demographics.IdentificationType;

/**
 * Created by zamzam on 15/08/22.
 */
public class IdentificationTypeFactory {
    public static IdentificationType getIdentificationType(String idType, String description) {
        IdentificationType identificationType = new IdentificationType.Builder().idvalue(idType)
                .description(description)
                .id(KeyGenerator.getEntityId())
                .build();
        return identificationType;
    }
}
