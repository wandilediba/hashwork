package hashwork.client.content.payroll.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.payroll.model.SalaryGradeModel;

/**
 * Created by zamzam on 15/09/22.
 */
public class SalaryGradeForm extends FormLayout {
    private final SalaryGradeModel bean;
    public final BeanItem<SalaryGradeModel> item;
    public final FieldGroup binder;

    // Define Public Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    
    public SalaryGradeForm(){
        bean = new SalaryGradeModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();


        // Define Fields
        // Text Fields
        TextField gradeName = UIComponent.getGridTextField("Location Name :", "name", SalaryGradeModel.class, binder);
        TextField notes = UIComponent.getGridTextField("Location  Code :", "code", SalaryGradeModel.class, binder);
        TextField midAmount = UIComponent.getGridTextField("Latitude :", "latitude", SalaryGradeModel.class, binder);
        TextField endAmount = UIComponent.getGridTextField("Longitude :", "longitude", SalaryGradeModel.class, binder);
        TextField startAmount = UIComponent.getGridTextField("Longitude :", "longitude", SalaryGradeModel.class, binder);
        TextField currentAmount = UIComponent.getGridTextField("Longitude :", "longitude", SalaryGradeModel.class, binder);

//        //ComboBox Fields
//        ComboBox currencyId = UIComboBox.getLocationTypeComboBox("Location Type :", "locationTypeId", SalaryGradeModel.class, binder);

        // Create a field group and use it to bind the fields in the layout
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        // First ROW
        grid.addComponent(gradeName, 0, 0);
        grid.addComponent(notes, 1, 0);
        grid.addComponent(midAmount, 2, 0);

        //Second ROW
        grid.addComponent(endAmount, 0, 1);
        grid.addComponent(startAmount, 1, 1);
        grid.addComponent(currentAmount, 2, 1);
        
        //Third ROW
//        grid.addComponent(currencyId, 0, 2);
        


        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 4, 2, 4);
        grid.addComponent(buttons, 0, 5, 2, 5);

        addComponent(grid);

    }
}
