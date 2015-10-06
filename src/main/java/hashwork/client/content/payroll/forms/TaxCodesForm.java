package hashwork.client.content.payroll.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.payroll.model.TaxCodesModel;

/**
 * Created by zamzam on 2015/10/02.
 */
public class TaxCodesForm extends FormLayout {
    private final TaxCodesModel bean;
    public final BeanItem<TaxCodesModel> item;
    public final FieldGroup binder;

    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

    public TaxCodesForm(){
        bean = new TaxCodesModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();

        TextField code = UIComponent.getTextField("Amount :", "amount", TaxCodesModel.class, binder);
        TextField codeType = UIComponent.getTextField("Tax Code Type", "codeType", TaxCodesModel.class, binder);
        TextArea codeDescription = UIComponent.getTextArea("Tax Code Description", "codeDescription", TaxCodesModel.class,binder,10);

        addComponent(code);
        addComponent(codeType);
        addComponent(codeDescription);


        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
