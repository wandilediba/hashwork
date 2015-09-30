package hashwork.client.content.payroll.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.payroll.model.BenefitFrequencyModel;

import java.awt.*;

/**
 * Created by zamzam on 15/09/21.
 */
public class BenefitFrequencyForm extends FormLayout {
    private final BenefitFrequencyModel bean;
    public final BeanItem<BenefitFrequencyModel> item;
    public final FieldGroup binder;

    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    
    public BenefitFrequencyForm(){
        bean = new BenefitFrequencyModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();

        TextField frequency = UIComponent.getTextField("Frequency :", "frequency", BenefitFrequencyModel.class, binder);
        addComponent(frequency);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
    
    
}
