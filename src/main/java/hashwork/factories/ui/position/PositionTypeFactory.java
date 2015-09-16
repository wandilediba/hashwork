package hashwork.factories.ui.position;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.position.PositionType;

/**
 * Created by garran on 2015/09/13.
 */
public class PositionTypeFactory {
    public static PositionType getPositionType(String name) {
        PositionType positionType = new PositionType.Builder()
                .id(KeyGenerator.getEntityId())
                .name(name).build();
        return positionType;
    }
}
