package hashwork.client.content.payroll.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.payroll.model.BenefitTypeModel;

/**
 * Created by zamzam on 15/09/21.
 */
public class BenefitTypeForm extends FormLayout {
    private final BenefitTypeModel bean;
    public final BeanItem<BenefitTypeModel> item;
    public final FieldGroup binder;

    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

    public BenefitTypeForm(){
        bean = new BenefitTypeModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();

        TextField benefitTypeName = UIComponent.getTextField("Benefit Type Name :", "benefitTypeName", BenefitTypeModel.class, binder);
        TextField amount = UIComponent.getTextField("Amount :", "amount", BenefitTypeModel.class, binder);
        //  TextField currencyId = UIComponent.getTextField("CurrencyModel ID :", "currencyId", BenefitTypeModel.class, binder);

        //ComboBox Fields
        ComboBox currencyId = UIComboBox.getLocationTypeComboBox("CurrencyModel :", "currencyId", BenefitTypeModel.class, binder);

        addComponent(benefitTypeName);
        addComponent(amount);
        addComponent(currencyId);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
    
}
