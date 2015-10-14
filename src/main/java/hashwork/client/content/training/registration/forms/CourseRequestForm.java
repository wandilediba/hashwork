package hashwork.client.content.training.registration.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.facade.TrainingFacade;
import hashwork.app.facade.UtilFacade;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.training.registration.model.CourseRequestModel;
import hashwork.domain.ui.training.CompetencyRequestAggregate;
import hashwork.domain.ui.training.TrainingInstitution;
import hashwork.domain.ui.util.Funder;

import java.util.Set;

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
    private final UIComboBoxHelper UIComboBox;
    private final UIComponentHelper UIComponent;

    public CourseRequestForm() {
        bean = new CourseRequestModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        UIComponent = new UIComponentHelper();
        UIComboBox = new UIComboBoxHelper();


        TextField requestName = UIComponent.getGridTextField("Request Name :", "requestName", CourseRequestModel.class, binder);

        DateField prefferedStart = UIComponent.getGridDateField("Preferred End Date :", "prefferedStart", CourseRequestModel.class, binder);
        DateField preferredEnd = UIComponent.getGridDateField("Preferred End Date :", "preferredEnd", CourseRequestModel.class, binder);


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

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 6, 2, 6);
        grid.addComponent(buttons, 0, 8, 2, 8);

        addComponent(grid);

    }



    private ListSelect getTrainingInstitutionList(String label, String field) {
        trainingInstitutions.setCaption(label);
        Set<TrainingInstitution> trainingInst = TrainingFacade.trainingInstitutionService.findAll();
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
        Set<Funder> fundersc = UtilFacade.funderService.findAll();
        for (Funder funder : fundersc) {
            funders.setItemCaption(funder.getId(), funder.getTrainingFunderName());
            funders.setNullSelectionAllowed(false);
            funders.setMultiSelect(true);
            funders.addItem(funder.getId());
            funders.setWidth("250px");
        }

        return funders;
    }


    //getCompetenciesList
    private ListSelect getCompetenciesList(String label, String field) {
        competences.setCaption(label);
        Set<CompetencyRequestAggregate> competencies = TrainingFacade.competencyRequestAggregateService.getApprovedRequests();
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