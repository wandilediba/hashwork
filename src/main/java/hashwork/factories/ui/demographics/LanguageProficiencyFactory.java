package hashwork.factories.ui.demographics;

import hashwork.domain.ui.demographics.LanguageProficiency;

/**
 * Created by zamzam on 15/08/22.
 */
public class LanguageProficiencyFactory {
    public static LanguageProficiency getLanguageProficiency(String proficiency){
        LanguageProficiency languageProficiency = new LanguageProficiency.Builder()
                .proficiency(proficiency).build();
        return languageProficiency;
    }
}
