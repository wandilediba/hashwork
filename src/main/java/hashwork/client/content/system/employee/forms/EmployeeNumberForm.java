/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.client.content.system.employee.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.client.content.system.employee.model.EmployeeNumberModel;

/**
 *
 * @author Garran
 */
public class EmployeeNumberForm extends FormLayout {
    
    private final EmployeeNumberModel bean;
    public final BeanItem<EmployeeNumberModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    
    public EmployeeNumberForm() {
        bean = new EmployeeNumberModel();
        item = new BeanItem<EmployeeNumberModel>(bean);
        binder = new FieldGroup(item);
        
        TextField employeenumber = new TextField("EmployeeNumber");
        employeenumber.setNullRepresentation("");


        // Add the bean validator
        employeenumber.addValidator(new BeanValidator(EmployeeNumberModel.class, "employeenumber"));
        employeenumber.setImmediate(true);


        // Create a field group and use it to bind the fields in the layout

        binder.bind(employeenumber, "employeenumber");
        addComponent(employeenumber);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponent(save);
        buttons.addComponent(edit);
        buttons.addComponent(cancel);
        buttons.addComponent(update);
        buttons.addComponent(delete);

        // Determines which properties are shown, and in which order:
        edit.setVisible(false);
        update.setVisible(false);
        delete.setVisible(false);
        addComponent(buttons);
    }
}
