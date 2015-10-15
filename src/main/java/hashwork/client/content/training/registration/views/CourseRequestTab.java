package hashwork.client.content.training.registration.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.EducationFacade;
import hashwork.app.facade.PersonFacade;
import hashwork.app.facade.TrainingFacade;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.client.content.training.registration.InstitutionRegistrationMenu;
import hashwork.client.content.training.registration.forms.CourseRequestForm;
import hashwork.client.content.training.registration.model.CourseRequestModel;
import hashwork.client.content.training.registration.table.CourseRequestTable;
import hashwork.domain.people.Person;
import hashwork.domain.ui.education.Competency;
import hashwork.domain.ui.training.CourseRequest;
import hashwork.domain.ui.training.TrainingInstitution;
import hashwork.domain.ui.util.Funder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by hashcode on 2015/10/08.
 */
public class CourseRequestTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final CourseRequestForm form;
    private final CourseRequestTable table;
    private Collection<String> requestorsIds = new ArrayList<String>();
    private Collection<String> competenciesIds = new ArrayList<String>();
    private Collection<String> fundersIds = new ArrayList<String>();
    private Collection<String> trainingInstitutionIds = new ArrayList();

    public CourseRequestTab(MainLayout app) {
        main = app;
        form = new CourseRequestForm();
        table = new CourseRequestTable(main);
        setSizeFull();
        addComponent(form);
        addComponent(table);
        addListeners();
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        final Button source = event.getButton();
        if (source == form.save) {
            saveForm(form.binder);
        } else if (source == form.edit) {
            setEditFormProperties();
        } else if (source == form.cancel) {
            getHome();
        } else if (source == form.update) {
            saveEditedForm(form.binder);
        } else if (source == form.delete) {
            deleteForm(form.binder);
        }
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == table) {
            final CourseRequest courseRequest = TrainingFacade.courseRequestService.findById(table.getValue().toString());
            final CourseRequestModel bean = getBean(courseRequest);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        } else if (property == form.competences) {
            competenciesIds = (Collection<String>) property.getValue();
        } else if (property == form.funders) {
            fundersIds = (Collection<String>) property.getValue();
        } else if (property == form.trainingInstitutions) {
            trainingInstitutionIds = (Collection<String>) property.getValue();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            getEntity(binder);// See Bind values
            binder.commit();
            TrainingFacade.courseRequestService.save(getEntity(binder));
            getHome();
            Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void saveEditedForm(FieldGroup binder) {
        try {
            binder.commit();
            TrainingFacade.courseRequestService.save(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        TrainingFacade.courseRequestService.delete(getEntity(binder));
        getHome();
    }

    private CourseRequest getEntity(FieldGroup binder) {

        final CourseRequestModel courseRequestBean = ((BeanItem<CourseRequestModel>) binder.getItemDataSource()).getBean();
        final CourseRequest courseRequest = new CourseRequest.Builder()


                .build();


        return courseRequest;

    }

    private void getHome() {
        main.content.setSecondComponent(new InstitutionRegistrationMenu(main, "REQUEST"));
    }

    private void setEditFormProperties() {
        form.binder.setReadOnly(false);
        form.save.setVisible(false);
        form.edit.setVisible(false);
        form.cancel.setVisible(true);
        form.delete.setVisible(false);
        form.update.setVisible(true);
    }

    private void setReadFormProperties() {
        form.binder.setReadOnly(true);
        //Buttons Behaviou
        form.save.setVisible(false);
        form.edit.setVisible(false);
        form.cancel.setVisible(true);
        form.delete.setVisible(true);
        form.update.setVisible(false);
    }

    private void addListeners() {
        //Register Button Listeners
        form.save.addClickListener((Button.ClickListener) this);
        form.edit.addClickListener((Button.ClickListener) this);
        form.cancel.addClickListener((Button.ClickListener) this);
        form.update.addClickListener((Button.ClickListener) this);
        form.delete.addClickListener((Button.ClickListener) this);
        //Register Table Listerners
        table.addValueChangeListener((Property.ValueChangeListener) this);
        form.competences.addValueChangeListener((Property.ValueChangeListener) this);
        form.competences.setImmediate(true);

        form.funders.addValueChangeListener((Property.ValueChangeListener) this);
        form.funders.setImmediate(true);
        form.trainingInstitutions.addValueChangeListener((
                Property.ValueChangeListener) this);
        form.trainingInstitutions.setImmediate(true);
    }

    private CourseRequestModel getBean(CourseRequest courseRequest) {
        CourseRequestModel bean = new CourseRequestModel();
//        bean.setCompetencies(getCompetencyIds(courseRequest.getCompetencies()));
//        bean.setFunder(getFunderIds(courseRequest.getFunder()));
//        bean.setPreferredEnd(courseRequest.getPreferredEnd());
//        bean.setId(courseRequest.getId());
//        bean.setPrefferedStart(courseRequest.getPrefferedStart());
//        bean.setRequestName(courseRequest.getRequestName());
//        bean.setRequestors(getRequestorsId(courseRequest.getRequestors()));
//        bean.setTrainingInstitutions(getTrainingInstitutionIds(courseRequest.getTrainingInstitutions()));
        return bean;
    }

    private List<String> getCompetencyIds(List<Competency> competencies) {
        List<String> values = new ArrayList<String>();
        for (Competency value : competencies) {
            values.add(value.getId());
        }
        return values;
    }

    private List<String> getFunderIds(List<Funder> funders) {
        List<String> values = new ArrayList<String>();
        for (Funder value : funders) {
            values.add(value.getId());
        }
        return values;
    }

    private List<String> getRequestorsId(List<Person> requestors) {
        List<String> values = new ArrayList<String>();
        for (Person value : requestors) {
            values.add(value.getId());
        }
        return values;
    }

    private List<Competency> getCompetencies(Collection<String> competenciesId) {
        List<Competency> competencies = new ArrayList<Competency>();
        for (String id : competenciesId) {
            Competency competency = EducationFacade.competencyService.findById(id);
            competencies.add(competency);
        }
        return competencies;
    }

    private List<Person> getRequestors(Collection<String> competencesId) {
        Collection<String> requestIds = new HashSet<String>();
//        for (String id : competencesId) {
//            List<String> requestorsId = TrainingFacade.competencyRequestService.getRequestorsIds(id);
//            requestIds.addAll(requestorsId);
//        }
        List<Person> persons = new ArrayList<Person>();
        for (String id : requestIds) {
            Person person = PersonFacade.personService.findById(id);
            persons.add(person);
        }
        return persons;
    }

    private List<Funder> getFunders(Collection<String> fundersIds) {
        List<Funder> funders = new ArrayList<Funder>();
        for (String id : fundersIds) {
            Funder funder = UtilFacade.funderService.findById(id);
            funders.add(funder);
        }
        return funders;
    }

    private List<TrainingInstitution> getInstitutions(Collection<String> trainingInstitutions) {
        List<TrainingInstitution> ti = new ArrayList<TrainingInstitution>();
        for (String id : trainingInstitutions) {
            TrainingInstitution trainingInstitution = TrainingFacade.trainingInstitutionService.findById(id);
            ti.add(trainingInstitution);
        }
        return ti;
    }

    private List<String> getTrainingInstitutionIds(List<TrainingInstitution> trainingInstitutions) {
        List<String> values = new ArrayList<String>();
        for (TrainingInstitution value : trainingInstitutions) {
            values.add(value.getId());
        }
        return values;
    }
}