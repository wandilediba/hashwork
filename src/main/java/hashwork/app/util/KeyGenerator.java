package hashwork.app.util;

import java.util.UUID;

/**
 * Created by hashcode on 2015/08/22.
 */
public class KeyGenerator {
    public static String getEntityId() {
        return UUID.randomUUID().toString();
    }
}
