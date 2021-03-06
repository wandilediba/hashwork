package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.TrainingInstitution;

/**
 * Created by garran on 2015/09/13.
 */
public class TrainingInstitutionFactory {
    public static TrainingInstitution getTrainingInstitution(String trainingInstitutions, String cityId, String locationContactId) {
        TrainingInstitution trainingInstitution = new TrainingInstitution.Builder()
                .id(KeyGenerator.getEntityId())
                .trainingInstitution(trainingInstitutions)
                .cityId(cityId)
                .locationContactId(locationContactId)
                .build();
        return trainingInstitution;
    }
}
