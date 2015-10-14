package hashwork.client.content.training.institutions.forms;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.facade.EducationFacade;
import hashwork.app.facade.PeopleFacade;
import hashwork.app.facade.TrainingFacade;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.training.institutions.model.CourseModel;
import hashwork.domain.people.Person;
import hashwork.domain.ui.education.Competency;
import hashwork.domain.ui.training.CourseRequest;
import hashwork.domain.ui.training.TrainingInstitutionTrainer;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by hashcode on 2015/10/10.
 */
public class CourseForm extends FormLayout implements Property.ValueChangeListener {

    private final CourseModel bean;
    public final BeanItem<CourseModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    public final ListSelect compentencies = new ListSelect();
    public final ListSelect instructors = new ListSelect();
    private final GridLayout grid;
    private Date preferedStartDate;
    private Date preferredEndDate;
    private DateField startDate;
    private ListSelect competenciesList;
    final UIComponentHelper UIComponent;
    final UIComboBoxHelper UIComboBox;

    private DateField endDate;


    public CourseForm() {
        bean = new CourseModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        UIComponent = new UIComponentHelper();
        UIComboBox = new UIComboBoxHelper();


        TextField courseName = UIComponent.getGridTextField("Course Name :", "courseName", CourseModel.class, binder);
        TextField courseTopic = UIComponent.getGridTextField("Course Topic :", "courseTopic", CourseModel.class, binder);
        TextField creditHours = UIComponent.getGridTextField("Credit Hours :", "creditHours", CourseModel.class, binder);

        TextArea courseObjective = UIComponent.getGridTextArea("Course Objective :", "courseObjective", CourseModel.class, binder);


        //ComboBox Fields
        final ComboBox courseCategory = UIComboBox.getComboBox("Course category :", "courseCategoryId", CourseModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Person> employees = PeopleFacade.personService.findAll();
                for (Person employee : employees) {
                    comboBox.addItem(employee.getId());
                    comboBox.setItemCaption(employee.getId(), employee.getLastName() + " " + employee.getFirstName());
                }
            }
        });

        //ComboBox Fields
        final ComboBox courseStatus = UIComboBox.getComboBox("Course Status :", "courseStatusId", CourseModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Person> employees = PeopleFacade.personService.findAll();
                for (Person employee : employees) {
                    comboBox.addItem(employee.getId());
                    comboBox.setItemCaption(employee.getId(), employee.getLastName() + " " + employee.getFirstName());
                }
            }
        });

        //ComboBox Fields
        final ComboBox institutionName = UIComboBox.getComboBox("Training Institution :", "institutionNameId", CourseModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Person> employees = PeopleFacade.personService.findAll();
                for (Person employee : employees) {
                    comboBox.addItem(employee.getId());
                    comboBox.setItemCaption(employee.getId(), employee.getLastName() + " " + employee.getFirstName());
                }
            }
        });


        //ComboBox Fields
        final ComboBox courseRequest = UIComboBox.getComboBox("Course Request :", "courseRequestId", CourseModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Person> employees = PeopleFacade.personService.findAll();
                for (Person employee : employees) {
                    comboBox.addItem(employee.getId());
                    comboBox.setItemCaption(employee.getId(), employee.getLastName() + " " + employee.getFirstName());
                }
            }
        });


        competenciesList = getCompetenciesList("Select Competencies", null);
        ListSelect instructorsList = getInstructors("Select Instructors", "courseInstructorsIds");


//        startDate = getDateField("Preferred Start Date", "prefferedStartDate", preferedStartDate);
//        endDate = getDateField(" Preferred End Date", "prefferedEndDate", preferredEndDate);

        startDate = UIComponent.getGridDateField("Preferred Start Date :", "prefferedStartDate", CourseModel.class, binder);
        endDate = UIComponent.getGridDateField("Preferred End Date :", "preferredEndDate", CourseModel.class, binder);


        grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(courseRequest, 0, 0);

        grid.addComponent(startDate, 1, 0);
        grid.addComponent(endDate, 2, 0);

        grid.addComponent(courseName, 0, 1);
        grid.addComponent(courseCategory, 1, 1);
        grid.addComponent(creditHours, 2, 1);

        grid.addComponent(institutionName, 0, 2);
        grid.addComponent(courseStatus, 1, 2);
        grid.addComponent(courseTopic, 2, 2);

        grid.addComponent(instructorsList, 0, 3, 0, 4);
        grid.addComponent(competenciesList, 1, 3, 2, 4);


        grid.addComponent(courseObjective, 0, 5, 2, 6);


        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 6, 2, 6);
        grid.addComponent(buttons, 0, 8, 2, 8);
        addComponent(grid);

    }


    private ListSelect getCompetenciesList(String label, CourseRequest courseRequest) {
        compentencies.setCaption(label);

        if (courseRequest != null) {
            Set<Competency> requests = competencies(courseRequest.getCompetenciesIds());
            for (Competency competency : requests) {
                compentencies.setItemCaption(competency.getId(), competency.getName());
                compentencies.setNullSelectionAllowed(false);
                compentencies.setMultiSelect(true);
                compentencies.addItem(competency.getId());
            }
        } else {
            compentencies.removeAllItems();
        }

        return compentencies;
    }

    private Set<Competency> competencies(List<String> competenciesIds) {
        Set<Competency> requests = EducationFacade.competencyService
                .findAll()
                .parallelStream()
                .filter(competency -> competenciesIds.contains(competency.getId()))
                .collect(Collectors.toSet());
        return requests;
    }

    private ListSelect getInstructors(String label, String field) {
        instructors.setCaption(label);
        Set<TrainingInstitutionTrainer> trainingInstitutionTrainers = TrainingFacade.trainingInstitutionTrainerService.findAll();
        for (TrainingInstitutionTrainer trainer : trainingInstitutionTrainers) {
            instructors.setItemCaption(trainer.getId(), trainer.getFirstName() + " " + trainer.getLastName());
            instructors.setNullSelectionAllowed(false);
            instructors.setMultiSelect(true);
            instructors.addItem(trainer.getId());
        }
        instructors.setWidth("250px");
        return instructors;
    }


    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        CourseRequest courseRequest = null;
        if (event.getProperty().getValue() != null) {
            String id = (String) event.getProperty().getValue();
            courseRequest = TrainingFacade.courseRequestService.findById(id);
            preferedStartDate = courseRequest.getPrefferedStart();
            preferredEndDate = courseRequest.getPreferredEnd();

        } else {
            preferedStartDate = null;
            preferredEndDate = null;

        }
        grid.removeComponent(startDate);
        grid.removeComponent(endDate);
//        startDate = getDateField("Preferred Start Date", "prefferedStartDate", preferedStartDate);
//        endDate = getDateField(" Preferred End Date", "prefferedEndDate", preferredEndDate);
        startDate = UIComponent.getGridDateField("Preferred Start Date :", "prefferedStartDate", CourseModel.class, binder);
        endDate = UIComponent.getGridDateField("Preferred End Date :", "preferredEndDate", CourseModel.class, binder);
        grid.addComponent(startDate, 1, 0);
        grid.addComponent(endDate, 2, 0);

        grid.removeComponent(competenciesList);
        competenciesList = getCompetenciesList("Select Competencies", courseRequest);
        grid.addComponent(competenciesList, 1, 3, 2, 4);

    }
}