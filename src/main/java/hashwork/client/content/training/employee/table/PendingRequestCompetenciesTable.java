package hashwork.client.content.training.employee.table;

import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.Reindeer;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.CompetencyRequestAggregate;

import java.util.List;

/**
 * Created by hashcode on 2015/10/08.
 */
public class PendingRequestCompetenciesTable extends Table {
    private final MainLayout main;

    public PendingRequestCompetenciesTable(final MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Competency Name", String.class, null);
        addContainerProperty("Number of Requests", Integer.class, null);
        addContainerProperty("Status", String.class, null);
        addContainerProperty("Approve", Button.class, null);
        addContainerProperty("Reject", Button.class, null);

        List<CompetencyRequestAggregate> requests = TrainingFacade.getCompetencyRequestService().getPendingRequests();
        for (final CompetencyRequestAggregate re : requests) {
            Button approve = new Button("Approve", new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    TrainingFacade.getCompetencyRequestService().aprroveRequests(re.getId());
                    main.content.setSecondComponent(new EmployeeTrainingMenu(main, "PENDING"));
                }
            });
            Button reject = new Button("Reject", new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    TrainingFacade.getCompetencyRequestService().rejectRequests(re.getId());
                    main.content.setSecondComponent(new EmployeeTrainingMenu(main, "PENDING"));
                }
            });


            approve.setStyleName(Reindeer.BUTTON_LINK);
            reject.setStyleName(Reindeer.BUTTON_LINK);

            addItem(new Object[]{re.getCompetencyName(),
                    re.getCount(),
                    re.getStatus(),
                    approve,
                    reject
            }, re.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
