package hashwork.client.content.system.office.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.facade.OfficeFacade;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.office.model.OfficeModel;
import hashwork.domain.office.Office;

import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by zamzam on 2015/10/07.
 */
public class OfficeForm extends FormLayout {
    private final OfficeModel bean;
    public final BeanItem<OfficeModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    
    public OfficeForm(){
        bean = new OfficeModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        // Define Fields
        // Text Fields
        TextField name = UIComponent.getGridTextField("Location Name :", "name", OfficeModel.class, binder);
        TextField description = UIComponent.getGridTextField("Description :", "description", OfficeModel.class, binder);
        TextField active = UIComponent.getGridTextField("Active :", "active", OfficeModel.class, binder);
        DateField dateEstablished = UIComponent.getDateField("Date Estabished :", "dateEstablished", OfficeModel.class, binder);


        //ComboBox Fields
        final ComboBox contactId = UIComboBox.getComboBox("Office Contact Type :", "contactId", OfficeModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Office> Offices = OfficeFacade.officeService.findAll();
                for (Office Office : Offices) {
                    comboBox.addItem(Office.getId());
                    comboBox.setItemCaption(Office.getId(), Office.getName());
                }
            }
        });

        //ComboBox Fields
        final ComboBox officeTypeId = UIComboBox.getComboBox("Office Type :", "officeTypeId", OfficeModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Office> offices = OfficeFacade.officeService.findAll();
                for (Office office : offices) {
                    comboBox.addItem(office.getId());
                    comboBox.setItemCaption(office.getId(), office.getName());
                }
            }
        });

        //ComboBox Fields
        final ComboBox cityId = UIComboBox.getComboBox("City :", "cityId", OfficeModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Office> offices = OfficeFacade.officeService.findAll();
                for (Office office : offices) {
                    comboBox.addItem(office.getId());
                    comboBox.setItemCaption(office.getId(), office.getName());
                }
            }
        });




        // Create a field group and use it to bind the fields in the layout
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        // First ROW
        grid.addComponent(officeTypeId, 0, 0);
        grid.addComponent(name, 1, 0);
        grid.addComponent(description, 2, 0);

        //Second ROW
        grid.addComponent(cityId, 0, 1);
        grid.addComponent(active, 1, 1);
        grid.addComponent(dateEstablished, 2, 1);

        //Third ROW
        grid.addComponent(contactId,0,2);


        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 4, 2, 4);
        grid.addComponent(buttons, 0, 5, 2, 5);

        addComponent(grid);


    }
}
