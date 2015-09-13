package hashwork.factories.ui.position;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.position.PositionLifeCycle;

import java.util.Date;

/**
 * Created by garran on 2015/09/13.
 */
public class PositionLifeCycleFactory {
    public static PositionLifeCycle getAddressType(String positionId, Date dateofAction,String status) {
        PositionLifeCycle positionLifeCycle = new PositionLifeCycle.Builder()
                .id(KeyGenerator.getEntityId())
                .positionId(positionId)
                .dateofAction(dateofAction)
                .status(status)
                .build();
        return positionLifeCycle;
    }
}
