package hashwork.client.content.system.jobs.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.facade.UtilFacade;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.jobs.model.BenefitTypeModel;
import hashwork.domain.ui.util.Currency;

import java.util.Set;
import java.util.function.Consumer;


/**
 * Created by hashcode on 2015/09/16.
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

    public BenefitTypeForm() {
        bean = new BenefitTypeModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        // Define Fields
        // Text Fields

        final TextField benefitTypeName = UIComponent.getGridTextField("benefit Type :", "benefitTypeName", BenefitTypeModel.class, binder);
        final TextField amount = UIComponent.getGridBigDecimalTextField("Amount :", "amount", BenefitTypeModel.class, binder);

        //ComboBox Fields
        final ComboBox currency = UIComboBox.getComboBox("Currency :", "currencyId", BenefitTypeModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Currency> currencies = UtilFacade.currencyServices.findAll();
                for (Currency currency : currencies) {
                    comboBox.addItem(currency.getId());
                    comboBox.setItemCaption(currency.getId(), currency.getName());
                }
            }
        });


        // Create a field group and use it to bind the fields in the layout
        final GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        // First ROW
        grid.addComponent(currency, 0, 0);
        grid.addComponent(benefitTypeName, 1, 0);
        grid.addComponent(amount, 2, 0);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 4, 2, 4);
        grid.addComponent(buttons, 0, 5, 2, 5);

        addComponent(grid);
    }
}
