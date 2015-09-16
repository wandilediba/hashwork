package hashwork.factories.ui.demographics;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.demographics.GenderList;

/**
 * Created by hashcode on 2015/08/16.
 */
public class GenderListFactory {
    public static GenderList getGenderList(String gender) {
        GenderList genderList = new GenderList
                .Builder()
                .id(KeyGenerator.getEntityId())
                .gender(gender).build();
        return genderList;
    }
}