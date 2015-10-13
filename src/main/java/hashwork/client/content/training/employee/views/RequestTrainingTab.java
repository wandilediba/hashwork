package hashwork.client.content.training.employee.views;

import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;
import hashwork.client.content.training.employee.EmployeeTrainingMenu;
import hashwork.client.content.training.employee.forms.RequestTrainingForm;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by hashcode on 2015/10/08.
 */
public class RequestTrainingTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final RequestTrainingForm form;
    private Collection<String> competencyIds = new ArrayList<String>();

    public RequestTrainingTab(MainLayout app) {
        main = app;
        form = new RequestTrainingForm(main);
        setSizeFull();
        addComponent(form);

        addListeners();
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        final Button source = event.getButton();
        if (source == form.submitRequest) {
            submitRequest(competencyIds);
        } else if (source == form.cancelSubmission) {
            getHome();
        }
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
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
        form.cancelSubmission.addClickListener((Button.ClickListener) this);
        form.submitRequest.addClickListener((Button.ClickListener) this);

        //Register Form Listerners
        form.select.addValueChangeListener((Property.ValueChangeListener) this);
        form.select.setImmediate(true);
    }

    private void submitRequest(Collection<String> competencyIds) {
//        Person requester = new GetUserCredentials().getLoggedInUser();
        if (competencyIds.size() > 0) {
            for (String competencyId : competencyIds) {
//                Competency competency = EducationFacade.getCompetencyModelService().findById(competencyId);
//                CompetencyRequest request = new TrainingFactory.CompetencyRequestBuilder(competency.getName(), competency.getId())
//                        .requestDate(new Date())
//                        .requestorId(requester.getId())
//                        .requestorName(requester.getFirstName() + " " + requester.getLastName())
//                        .status(CompetencyRequestStatus.PENDING.name())
//                        .build();
//                TrainingFacade.getCompetencyRequestsModelService().persist(request);
            }
            Notification.show("Your Requests Have been Submitted", Notification.Type.HUMANIZED_MESSAGE);
            getHome();

        } else {
            Notification.show("Your Need to Select Competencies", Notification.Type.WARNING_MESSAGE);
        }
    }
}
