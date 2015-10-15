package hashwork.client.content.system.training.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.CompetencyEvaluation;

import java.util.Set;

/**
 * Created by sihle on 2015/10/08.
 */
public class CompetencyEvaluationTable extends Table {
    private final MainLayout main;

    public CompetencyEvaluationTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Id", String.class, null);
        addContainerProperty("Competition Type Name", String.class, null);
        addContainerProperty("Description", String.class, null);

        Set<CompetencyEvaluation> competencyEvaluatons = TrainingFacade.competencyEvaluationService.findAll();
        for (CompetencyEvaluation competencyEvaluaton : competencyEvaluatons) {
            addItem(new Object[]{competencyEvaluaton.getCompTypeName(),
                            competencyEvaluaton.getDescription()},
                    competencyEvaluaton.getId());
        }
        setNullSelectionAllowed(false);
        setSelectable(true);
        setImmediate(true);

    }
}