package hashwork.client.content.system.training.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.CompetencyRequest;

import java.util.Set;

/**
 * Created by sihle on 2015/10/08.
 */
public class CompetencyRequestTable extends Table {
    private final MainLayout main;

    public CompetencyRequestTable(MainLayout main){
        this.main = main;
        setSizeFull();

        addContainerProperty("Competency Name", String.class, null);
        addContainerProperty("competency Id", String.class, null);
        addContainerProperty("Request Date", String.class, null);
        addContainerProperty("Requestor Name", String.class, null);
        addContainerProperty("Requestor Id", String.class, null);
        addContainerProperty("Status", String.class, null);
        addContainerProperty("Reject Comment", String.class, null);

        Set<CompetencyRequest> competencyRequests = TrainingFacade.competencyRequestService.findAll();
        for(CompetencyRequest competencyRequest: competencyRequests){
            addItem(new Object[]{competencyRequest.getCompetencyName(),
                    competencyRequest.getCompetencyId(),
                    competencyRequest.getRequestDate(),
                    competencyRequest.getRequestorName(),
                    competencyRequest.getRequestorId(),
                    competencyRequest.getStatus(),
                    competencyRequest.getRejectComment()},
                    competencyRequest.getId());
        }
        setNullSelectionAllowed(false);
        setSelectable(true);
        setImmediate(true);

    }
}