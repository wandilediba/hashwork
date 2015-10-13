package hashwork.client.content.system.training.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.CompetencyRequestAggregate;

import java.util.Set;

/**
 * Created by sihle on 2015/10/08.
 */
public class CompetencyRequestAggregateTable extends Table {
    private final MainLayout main;

    public CompetencyRequestAggregateTable(MainLayout main){
        this.main = main;
        setSizeFull();

        addContainerProperty("Competency Name", String.class, null);
        addContainerProperty("Status", String.class, null);
        addContainerProperty("Count", String.class, null);

        Set<CompetencyRequestAggregate> competencyRequestAggregates = TrainingFacade.competencyRequestAggregateService.findAll();
        for(CompetencyRequestAggregate competencyRequestAggregate: competencyRequestAggregates){
            addItem(new Object[]{competencyRequestAggregate.getCompetencyName(),
                    competencyRequestAggregate.getStatus(),
                    competencyRequestAggregate.getCount()},
                    competencyRequestAggregate.getId());
        }
        setNullSelectionAllowed(false);
        setSelectable(true);
        setImmediate(true);
    }
}