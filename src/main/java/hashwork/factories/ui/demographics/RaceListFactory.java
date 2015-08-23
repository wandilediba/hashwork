package hashwork.factories.ui.demographics;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.demographics.RaceList;

/**
 * Created by zamzam on 15/08/22.
 */
public class RaceListFactory {
    public static RaceList getRaceList(String raceName) {
        RaceList raceList = new RaceList.Builder()
                .raceName(raceName)
                .id(KeyGenerator.getEntityId())
                .build();
        return raceList;
    }
}
