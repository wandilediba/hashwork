package hashwork.client.content.training.employee.forms;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TwinColSelect;
import hashwork.app.facade.EducationFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.education.Competency;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by hashcode on 2015/10/08.
 */
public class RequestTrainingForm extends FormLayout {
    private final MainLayout main;
    public Button submitRequest = new Button("Submit Requests");
    public Button cancelSubmission = new Button("Cancel");
    public final TwinColSelect select = new TwinColSelect();
    private final HorizontalLayout buttons = new HorizontalLayout();

    public RequestTrainingForm(MainLayout main) {
        this.main = main;
        submitRequest.setSizeFull();
        cancelSubmission.setSizeFull();

        select.setSizeFull();

        buttons.setSizeFull();
        buttons.addComponent(submitRequest);
        buttons.addComponent(cancelSubmission);

        // Set the column captions (optional)
        select.setLeftColumnCaption("Choose from this List of Competencies");
        select.setRightColumnCaption("Required Competencies");

        // Put some data in the select
        Set<Competency> competencies = EducationFacade.competencyService
                .findAll()
                .stream()
                .sorted((c1, c2) -> c1.getName().compareTo(c2.getName()))
                .collect(Collectors.toSet());
        for (Competency competency : competencies) {
            select.setItemCaption(competency.getId(), competency.getCompetencyTypeId() + " - " + competency.getName());
            select.addItem(competency.getId());
        }

        // Set the number of visible items
        select.setRows(competencies.size());
        addComponent(select);
        addComponent(buttons);

    }
}
