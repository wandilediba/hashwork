package hashwork.factories.ui.position;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.position.DepartureReason;

/**
 * Created by garran on 2015/09/13.
 */
public class DepartureReasonFactory {
    public static DepartureReason getDepartureReason(String reasonName, String description) {
        DepartureReason departureReason = new DepartureReason.Builder()
                .id(KeyGenerator.getEntityId())
                .reasonName(reasonName)
                .description(description)
                .build();
        return departureReason;
    }
}
