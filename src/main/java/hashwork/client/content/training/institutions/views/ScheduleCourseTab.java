package hashwork.client.content.training.institutions.views;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.client.content.training.institutions.InstitutionManagementMenu;
import hashwork.client.content.training.institutions.forms.ScheduledCourseForm;
import hashwork.client.content.training.institutions.model.ScheduledCourseModel;
import hashwork.client.content.training.institutions.table.ScheduledCourseTable;
import hashwork.domain.ui.training.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hashcode on 2015/10/08.
 */
public class ScheduleCourseTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final MainLayout main;
    private final ScheduledCourseTable table;
    private final ScheduledCourseForm form;

    public ScheduleCourseTab(MainLayout app) {

        main = app;
        form = new ScheduledCourseForm();
        table = new ScheduledCourseTable(main);
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

        }
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
        //Register Table Listerners
        table.addValueChangeListener((Property.ValueChangeListener) this);
    }

    private void setEditFormProperties() {
        form.binder.setReadOnly(false);
        form.save.setVisible(false);
        form.edit.setVisible(false);
        form.cancel.setVisible(true);
        form.delete.setVisible(false);
        form.update.setVisible(true);
    }

    private void saveEditedForm(FieldGroup binder) {
        try {

            binder.commit();
            TrainingFacade.scheduledCourseService.save(getEntity(binder));

        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        TrainingFacade.scheduledCourseService.delete(getEntity(binder));
        getHome();
    }

    private void saveForm(FieldGroup binder) {
        try {

            binder.commit();
            ScheduledCourse scheduledCourse = getEntity(binder);
            TrainingFacade.scheduledCourseService.save(scheduledCourse);
//            Course course = scheduledCourse.getCourseName();
//            course.getScheduledCourses().add(scheduledCourse);
//            TrainingFacade.scheduledCourseService.save(course);
            getHome();
            Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            getEntity(binder);
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private ScheduledCourse getEntity(FieldGroup binder) {
        ScheduledCourseModel bean = ((BeanItem<ScheduledCourseModel>) binder.getItemDataSource()).getBean();

//        Status status = UtilFacade.getStatusModelService().findById(bean.getCourseStatusId());

        Course course = TrainingFacade.courseService.findById(bean.getCourseNameId());

        ScheduledCourse scheduledCourse = new ScheduledCourse.Builder()
                .courseCapacity(bean.getCourseCapacity())
//                .courseFunders(getFunders(course.getCourseRequest()))
//                .courseRequestors(getCourseRequestors(course.getCourseRequest()))
//                .dateRequested(course.getCourseRequest().getRequestedDate())
//                .endDate(bean.getEndDate())
//                .startDate(bean.getStartDate())
//                .venue(bean.getVenue())
//                .status("PROPOSED")
                .build();

        return scheduledCourse;
    }

    private void getHome() {
        main.content.setSecondComponent(new InstitutionManagementMenu(main, "SCHEDULE"));
    }

    private List<CourseFundingSource> getFunders(CourseRequest courseRequest) {

        List<CourseFundingSource> cs = new ArrayList<CourseFundingSource>();
//        List<Funder> f = courseRequest.getFunder();
//        for (Funder funder : f) {
//            cs.add(TrainingFactory.getCourseFunder(funder));
//        }
        return cs;
    }

    private List<ScheduledCourseRequestor> getCourseRequestors(CourseRequest courseRequest) {
        List<ScheduledCourseRequestor> scheduledCourseRequestor = new ArrayList<ScheduledCourseRequestor>();
//        List<Person> req = courseRequest.getRequestors();
//        for (Person person : req) {
//            scheduledCourseRequestor.add(TrainingFactory.getCourseRequestors(person));
//        }
        return scheduledCourseRequestor;
    }
}