package hashwork.client.content.training.institutions.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.facade.TrainingFacade;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.training.institutions.model.ScheduledCourseModel;
import hashwork.domain.ui.training.Course;

import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by hashcode on 2015/10/10.
 */
public class ScheduledCourseForm extends FormLayout {

    private final ScheduledCourseModel bean;
    public final BeanItem<ScheduledCourseModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public ScheduledCourseForm() {
        bean = new ScheduledCourseModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();


        TextField courseCapacity = UIComponent.getGridTextField("Course Capacity:", "courseCapacity", ScheduledCourseModel.class, binder);
        TextField venue = UIComponent.getGridTextField("Course Venue :", "venue", ScheduledCourseModel.class, binder);


        DateField startDate = UIComponent.getGridDateField("Start Date :", "startDate", ScheduledCourseModel.class, binder);
        DateField endDate = UIComponent.getGridDateField("End Date :", "endDate", ScheduledCourseModel.class, binder);


        //ComboBox Fields
        final ComboBox course = UIComboBox.getComboBox("Select Course :", "courseNameId", ScheduledCourseModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Course> courses = TrainingFacade.courseService.findAll();
                for (Course course : courses) {
                    comboBox.addItem(course.getId());
                    comboBox.setItemCaption(course.getId(), course.getCourseName());
                }
            }
        });

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();
        grid.addComponent(course, 0, 0, 1, 0);
        grid.addComponent(courseCapacity, 2, 0);

        grid.addComponent(startDate, 0, 1);
        grid.addComponent(endDate, 1, 1);
        grid.addComponent(venue, 2, 1);


        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 5, 2, 5);
        grid.addComponent(buttons, 0, 6, 2, 6);

        addComponent(grid);
    }

}