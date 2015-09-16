package hashwork.factories.ui.training;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.training.CompetencyRequestAggregate;

/**
 * Created by garran on 2015/09/13.
 */
public class CompetencyRequestAggregateFactory {
    public static CompetencyRequestAggregate getCompetencyRequestAggregate(String competencyName, String status, int count){
        CompetencyRequestAggregate competencyRequestAggregate = new CompetencyRequestAggregate.Builder()
                .id(KeyGenerator.getEntityId())
                .competencyName(competencyName)
                .status(status)
                .count(count)
                .build();
        return competencyRequestAggregate;
    }
}
