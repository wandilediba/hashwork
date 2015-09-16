package hashwork.factories.ui.demographics;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.demographics.Language;

/**
 * Created by zamzam on 15/08/22.
 */
public class LanguageFactory {
    public static Language getLanguage(String name) {
        Language language = new Language.Builder()
                .id(KeyGenerator.getEntityId())
                .name(name).build();
        return language;
    }
}
