package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.CompetencyEvaluation;

/**
 * Created by garran on 2015/09/13.
 */
public class CompetencyEvaluationFactory {
    public static CompetencyEvaluation getCompetencyEvaluation(String compTypeName, String description) {
        CompetencyEvaluation competencyEvaluation = new CompetencyEvaluation.Builder()
                .id(KeyGenerator.getEntityId())
                .compType(compTypeName)
                .description(description)
                .build();
        return competencyEvaluation;
    }
}
