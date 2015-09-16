package hashwork.factories.ui.util;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.util.AccidentTypeList;

/**
 * Created by DibaW on 9/7/2015.
 */
public class AccidentTypeListFactory {

    public static AccidentTypeList getAccidentTpyeList(String name, String description){

        AccidentTypeList accidentTypeList = new AccidentTypeList.Builder()
                                                .id(KeyGenerator.getEntityId())
                                                .name(name)
                                                .description(description)
                                                .build();


        return accidentTypeList;
    }
}
