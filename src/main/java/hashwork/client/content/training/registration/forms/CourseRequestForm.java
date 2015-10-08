package hashwork.client.content.training.registration.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.facade.TrainingFacade;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.training.registration.model.CourseRequestModel;
import hashwork.domain.ui.training.CompetencyRequestAggregate;
import hashwork.domain.ui.training.TrainingInstitution;
import hashwork.domain.ui.util.Funder;

import java.util.List;

/**
 * Created by hashcode on 2015/10/08.
 */
public class CourseRequestForm extends FormLayout {

    private final CourseRequestModel bean;
    public final BeanItem<CourseRequestModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    public final ListSelect competences = new ListSelect();
    public final ListSelect funders = new ListSelect();
    public final ListSelect trainingInstitutions = new ListSelect();

    public CourseRequestForm() {
        bean = new CourseRequestModel();
        item = new BeanItem<CourseRequestModel>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        buttons.setSizeFull();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        TextField requestName = getTextField("Request Name", "requestName");
        DateField prefferedStart = getDateField("Preffered Start Date", "prefferedStart");
        DateField preferredEnd = getDateField("Preffered End Date", "preferredEnd");

        ListSelect competenciesList = getCompetenciesList("Select Competencies", "competencies");
        ListSelect fundersList = getFundersList("Select Funders", "requestors");
        ListSelect trainingInstitutionList = getTrainingInstitutionList("Select Training Institution", "trainingInstitutions");

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(requestName, 0, 0);
        grid.addComponent(prefferedStart, 1, 0);
        grid.addComponent(preferredEnd, 2, 0);
        grid.addComponent(competenciesList, 0, 2);
        grid.addComponent(trainingInstitutionList, 1, 2);
        grid.addComponent(fundersList, 2, 2);
        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 3, 2, 3);
        grid.addComponent(buttons, 0, 4, 2, 4);

        addComponent(grid);

    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(CourseRequestModel.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private DateField getDateField(String label, String field) {
        DateField textField = new DateField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.addValidator(new BeanValidator(CourseRequestModel.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private ListSelect getTrainingInstitutionList(String label, String field) {
        trainingInstitutions.setCaption(label);
        List<TrainingInstitution> trainingInst = TrainingFacade.getTrainingInstitutionModelService().findAll();
        for (TrainingInstitution trainingInstitution : trainingInst) {
            trainingInstitutions.setItemCaption(trainingInstitution.getId(), trainingInstitution.getTrainingInstitution());
            trainingInstitutions.setNullSelectionAllowed(false);
            trainingInstitutions.setMultiSelect(true);
            trainingInstitutions.addItem(trainingInstitution.getId());
            trainingInstitutions.setWidth("250px");
        }

        return trainingInstitutions;
    }

    private ListSelect getFundersList(String label, String field) {
        funders.setCaption(label);
        List<Funder> fundersc = UtilFacade.getFunderModelService().findAll();
        for (Funder funder : fundersc) {
            funders.setItemCaption(funder.getId(), funder.getTrainingFunderName());
            funders.setNullSelectionAllowed(false);
            funders.setMultiSelect(true);
            funders.addItem(funder.getId());
            funders.setWidth("250px");
        }

        return funders;
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        save.setSizeFull();
        edit.setSizeFull();
        cancel.setSizeFull();
        update.setSizeFull();
        delete.setSizeFull();

        buttons.addComponent(save);
        buttons.addComponent(edit);
        buttons.addComponent(cancel);
        buttons.addComponent(update);
        buttons.addComponent(delete);
        return buttons;
    }

    //getCompetenciesList
    private ListSelect getCompetenciesList(String label, String field) {
        competences.setCaption(label);
        List<CompetencyRequestAggregate> competencies = TrainingFacade.getCompetencyRequestService().getApprovedRequests();
        for (CompetencyRequestAggregate competency : competencies) {
            competences.setItemCaption(competency.getId(), competency.getCompetencyName());
            competences.setNullSelectionAllowed(false);
            competences.setMultiSelect(true);
            competences.addItem(competency.getId());
            competences.setWidth("250px");
        }
        return competences;
    }
}