package hashwork.factories.ui.util;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.util.Funder;

/**
 * Created by DibaW on 9/7/2015.
 */
public class FunderFactory {

    public static Funder getFunder(String trainingFunderName, String costCenter, String cityId, String LocationContactId) {

                    Funder funder = new Funder.Builder()
                                        .trainingFunderName(trainingFunderName)
                                        .costCenter(costCenter)
                                        .cityId(cityId)
                                        .id(KeyGenerator.getEntityId())
                                        .LocationContactId(LocationContactId)
                                        .build();

    return funder;
}

}
