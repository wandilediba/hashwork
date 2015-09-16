package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.TrainingInstitutionTrainer;

/**
 * Created by garran on 2015/09/13.
 */
public class TrainingInstitutionTrainerFactory {
    public static TrainingInstitutionTrainer getTrainingInstitutionTrainer(String title, String firstName, String lastName, String qualification) {
        TrainingInstitutionTrainer trainingInstitutionTrainer = new TrainingInstitutionTrainer.Builder()
                .id(KeyGenerator.getEntityId())
                .title(title)
                .firstName(firstName)
                .lastName(lastName)
                .qualification(qualification)
                .build();
        return trainingInstitutionTrainer;
    }
}
