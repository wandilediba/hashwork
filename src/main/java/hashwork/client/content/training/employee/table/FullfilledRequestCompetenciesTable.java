package hashwork.client.content.training.employee.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.CompetencyRequestAggregate;

import java.util.Set;

/**
 * Created by hashcode on 2015/10/08.
 */
public class FullfilledRequestCompetenciesTable extends Table {
    private final MainLayout main;

    public FullfilledRequestCompetenciesTable(final MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Competency Name", String.class, null);
        addContainerProperty("Number of Requests", Integer.class, null);
        addContainerProperty("Status", String.class, null);


        Set<CompetencyRequestAggregate> requests = TrainingFacade.competencyRequestAggregateService.getFullfilledRequests();

        for (CompetencyRequestAggregate re : requests) {


            addItem(new Object[]{re.getCompetencyName(),
                    re.getCount(),
                    re.getStatus(),
            }, re.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
