package hashwork.client.content.training.institutions.views;

import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.TrainingFacade;
import hashwork.domain.ui.training.Course;

/**
 * Created by hashcode on 2015/10/08.
 */
public class CreateCourseTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final HashWorkMain main;
    private final CourseForm form;
    private final CourseTable table;
    private Collection<String> competenciesIds = new ArrayList<String>();
    private Collection<String> instructors = new ArrayList<String>();

    public CreateCourseTab(HashWorkMain app) {
        main = app;
        form = new CourseForm();
        table = new CourseTable(main);
        setSizeFull();
        addComponent(form);
        addComponent(table);
        addListeners();
    }

    @Override
    public void buttonClick(ClickEvent event) {
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
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == table) {
            final TrainingInstitutionTrainer educationType = TrainingFacade.getTrainingInstitutionTrainerModelService().findById(table.getValue().toString());
            form.binder.setItemDataSource(new BeanItem<TrainingInstitutionTrainer>(educationType));
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
            TrainingFacade.getCourseModelService().persist(getEntity(binder));
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
            TrainingFacade.getCourseModelService().merge(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        TrainingFacade.getCourseModelService().remove(getEntity(binder));
        getHome();
    }

    private Course getEntity(FieldGroup binder) {

        CourseBean bean = ((BeanItem<CourseBean>) binder.getItemDataSource()).getBean();
        checkIfEdit(bean);
        Status status = UtilFacade.getStatusModelService().findById(bean.getCourseStatusId());

        TrainingInstitution trainingInstitution = TrainingFacade.getTrainingInstitutionModelService().findById(bean.getInstitutionNameId());
        List<CourseCompetencies> competencieses = new ArrayList<CourseCompetencies>();
        for (String id : competenciesIds) {
            Competency competency = EducationFacade.getCompetencyModelService().findById(id);
            CourseCompetencies courseCompetency = TrainingFactory.getCourseCompetencies(competency);
            competencieses.add(courseCompetency);
        }

        List<ScheduledCourseInstructor> trainers = new ArrayList<ScheduledCourseInstructor>();

        for (String id : instructors) {
            TrainingInstitutionTrainer trainer = TrainingFacade.getTrainingInstitutionTrainerModelService().findById(id);
            ScheduledCourseInstructor instructor = TrainingFactory.getCourseInstructors(trainer);
            trainers.add(instructor);

        }

        CourseCategory courseCategory = TrainingFacade.getCourseCategoryModelService().findById(bean.getCourseCategoryId());
        CourseRequest courseRequest = TrainingFacade.getCourseRequestService().findById(bean.getCourseRequestId());

        Course course = new TrainingFactory.CourseBuilder(bean.getCourseName(), courseCategory)
                .creditHours(bean.getCreditHours())
                .courseCompetencies(competencieses)
                .courseInstructors(trainers)
                .courseObjective(bean.getCourseObjective())
                .courseStatus(status)
                .courseTopic(bean.getCourseTopic())
                .institutionName(trainingInstitution)
                .courseRequest(courseRequest)
                .build();
        course.setId(bean.getId());

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
        form.save.addClickListener((ClickListener) this);
        form.edit.addClickListener((ClickListener) this);
        form.cancel.addClickListener((ClickListener) this);
        form.update.addClickListener((ClickListener) this);
        form.delete.addClickListener((ClickListener) this);

//        table.addValueChangeListener((ValueChangeListener) this);
        form.compentencies.addValueChangeListener((ValueChangeListener) this);
        form.compentencies.setImmediate(true);

        form.instructors.addValueChangeListener((ValueChangeListener) this);
        form.instructors.setImmediate(true);
    }

    private void checkIfEdit(CourseBean bean) {

        if (bean.getId() != null) {
            Course orig = TrainingFacade.getCourseModelService().findById(bean.getId());
            orig.getCourseCompetencies().clear();
            orig.getCourseInstructors().clear();
            TrainingFacade.getCourseModelService().merge(orig);
        }
    }
}