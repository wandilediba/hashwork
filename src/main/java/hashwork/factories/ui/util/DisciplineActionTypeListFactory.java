package hashwork.factories.ui.util;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.util.DisciplineActionTypeList;

/**
 * Created by DibaW on 9/7/2015.
 */
public class DisciplineActionTypeListFactory {

    public static DisciplineActionTypeList getDisciplineActionTypeList(String name, String description){

        DisciplineActionTypeList disciplineActionTypeList = new DisciplineActionTypeList.Builder()
                                                            .id(KeyGenerator.getEntityId())
                                                            .name(name)
                                                            .description(description)
                                                            .build();

        return disciplineActionTypeList;
    }
}
