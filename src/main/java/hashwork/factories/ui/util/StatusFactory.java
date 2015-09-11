package hashwork.factories.ui.util;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.util.Status;

/**
 * Created by DibaW on 9/7/2015.
 */
public class StatusFactory {

    public static Status getStatus(String statusType, String statusValue ){

        Status status = new Status.Builder()
                            .statusType(statusValue)
                            .statusValue(statusValue)
                            .id(KeyGenerator.getEntityId())
                            .build();

        return status;
    }
}
