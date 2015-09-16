package hashwork.factories.ui.demographics;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.demographics.LanguageProficiency;

/**
 * Created by zamzam on 15/08/22.
 */
public class LanguageProficiencyFactory {
    public static LanguageProficiency getLanguageProficiency(String proficiency) {
        LanguageProficiency languageProficiency = new LanguageProficiency
                .Builder()
                .id(KeyGenerator.getEntityId())
                .proficiency(proficiency).build();
        return languageProficiency;
    }
}
