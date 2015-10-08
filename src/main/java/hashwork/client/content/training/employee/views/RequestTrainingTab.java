package hashwork.client.content.training.employee.views;

import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.EducationFacade;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.training.employee.forms.RequestTrainingForm;
import hashwork.domain.people.Person;
import hashwork.domain.ui.education.Competency;
import hashwork.domain.ui.training.CompetencyRequest;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by hashcode on 2015/10/08.
 */
public class RequestTrainingTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final HashWorkMain main;
    private final RequestTrainingForm form;
    private Collection<String> competencyIds = new ArrayList<String>();

    public RequestTrainingTab(HashWorkMain app) {
        main = app;
        form = new RequestTrainingForm(main);
        setSizeFull();
        addComponent(form);

        addListeners();
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == form.submitRequest) {
            submitRequest(competencyIds);
        } else if (source == form.cancelSubmission) {
            getHome();
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == form.select) {
            Collection<String> ids = (Collection<String>) property.getValue();
            competencyIds = ids;
        }
    }

    private void getHome() {
        main.content.setSecondComponent(new EmployeeTrainingMenu(main, "LANDING"));
    }

    private void addListeners() {
        //Register Button Listeners
        form.cancelSubmission.addClickListener((ClickListener) this);
        form.submitRequest.addClickListener((ClickListener) this);

        //Register Form Listerners
        form.select.addValueChangeListener((ValueChangeListener) this);
        form.select.setImmediate(true);
    }

    private void submitRequest(Collection<String> competencyIds) {
        Person requester = new GetUserCredentials().getLoggedInUser();
        if (competencyIds.size() > 0) {
            for (String competencyId : competencyIds) {
                Competency competency = EducationFacade.getCompetencyModelService().findById(competencyId);
                CompetencyRequest request = new TrainingFactory.CompetencyRequestBuilder(competency.getName(), competency.getId())
                        .requestDate(new Date())
                        .requestorId(requester.getId())
                        .requestorName(requester.getFirstName() + " " + requester.getLastName())
                        .status(CompetencyRequestStatus.PENDING.name())
                        .build();
                TrainingFacade.getCompetencyRequestsModelService().persist(request);
            }
            Notification.show("Your Requests Have been Submitted", Notification.Type.HUMANIZED_MESSAGE);
            getHome();

        } else {
            Notification.show("Your Need to Select Competencies", Notification.Type.WARNING_MESSAGE);
        }
    }
}
