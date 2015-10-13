package hashwork.client.content.training.institutions.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.EducationFacade;
import hashwork.app.facade.TrainingFacade;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.client.content.system.training.table.CourseTable;
import hashwork.client.content.training.institutions.InstitutionManagementMenu;
import hashwork.client.content.training.institutions.forms.CourseForm;
import hashwork.client.content.training.institutions.model.CourseModel;
import hashwork.domain.ui.education.Competency;
import hashwork.domain.ui.training.*;
import hashwork.domain.ui.util.Status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by hashcode on 2015/10/08.
 */
public class CreateCourseTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final CourseForm form;
    private final CourseTable table;
    private Collection<String> competenciesIds = new ArrayList<>();
    private Collection<String> instructors = new ArrayList<>();

    public CreateCourseTab(MainLayout app) {
        main = app;
        form = new CourseForm();
        table = new CourseTable(main);
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
            final TrainingInstitutionTrainer educationType = TrainingFacade.trainingInstitutionTrainerService.findById(table.getValue().toString());
            form.binder.setItemDataSource(new BeanItem<>(educationType));
            setReadFormProperties();
        } else if (property == form.compentencies) {
            competenciesIds = (Collection<String>) property.getValue();
        } else if (property == form.instructors) {
            instructors = (Collection<String>) property.getValue();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {

            binder.commit();
            TrainingFacade.courseService.save(getEntity(binder));
            getHome();
            Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            getEntity(binder);
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void saveEditedForm(FieldGroup binder) {
        try {

            binder.commit();
            TrainingFacade.courseService.save(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        TrainingFacade.courseService.delete(getEntity(binder));
        getHome();
    }

    private Course getEntity(FieldGroup binder) {

        CourseModel bean = ((BeanItem<CourseModel>) binder.getItemDataSource()).getBean();
        checkIfEdit(bean);
        Status status = UtilFacade.statusService.findById(bean.getCourseStatusId());

        TrainingInstitution trainingInstitution = TrainingFacade.trainingInstitutionService.findById(bean.getInstitutionNameId());
        List<CourseCompetencies> competencieses = new ArrayList<>();
        for (String id : competenciesIds) {
            Competency competency = EducationFacade.competencyService.findById(id);
//            CourseCompetencies courseCompetency = TrainingFactory.getCourseCompetencies(competency);
//            competencieses.add(courseCompetency);
        }

        List<ScheduledCourseInstructor> trainers = new ArrayList<ScheduledCourseInstructor>();

        for (String id : instructors) {
            TrainingInstitutionTrainer trainer = TrainingFacade.trainingInstitutionTrainerService.findById(id);
//            ScheduledCourseInstructor instructor = TrainingFactory.getCourseInstructors(trainer);
//            trainers.add(instructor);

        }

        CourseCategory courseCategory = TrainingFacade.courseCategoryService.findById(bean.getCourseCategoryId());
        CourseRequest courseRequest = TrainingFacade.courseRequestService.findById(bean.getCourseStatusId());

        Course course = new Course.Builder()
                .creditHours(bean.getCreditHours())


                .build();


        return course;

    }

    private void getHome() {
        main.content.setSecondComponent(new InstitutionManagementMenu(main, "CREATE"));
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
        form.edit.setVisible(true);
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

//        table.addValueChangeListener((ValueChangeListener) this);
        form.compentencies.addValueChangeListener((Property.ValueChangeListener) this);
        form.compentencies.setImmediate(true);

        form.instructors.addValueChangeListener((Property.ValueChangeListener) this);
        form.instructors.setImmediate(true);
    }

    private void checkIfEdit(CourseModel bean) {

        if (bean.getInstitutionNameId() != null) {
//            Course orig = TrainingFacade.getCourseModelService().findById(bean.getId());
//            orig.getCourseCompetencies().clear();
//            orig.getCourseInstructors().clear();
//            TrainingFacade.getCourseModelService().merge(orig);
        }
    }
}