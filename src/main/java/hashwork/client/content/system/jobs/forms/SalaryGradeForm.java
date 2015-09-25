package hashwork.client.content.system.jobs.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.facade.UtilFacade;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.jobs.model.SalaryGradeModel;
import hashwork.domain.ui.util.Currency;

import java.util.Set;
import java.util.function.Consumer;


/**
 * Created by hashcode on 2015/09/16.
 */
public class SalaryGradeForm extends FormLayout {
    private final SalaryGradeModel bean;
    public final BeanItem<SalaryGradeModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public SalaryGradeForm() {
        bean = new SalaryGradeModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();


        // Text Fields
        TextField gradeName = UIComponent.getGridTextField("Grade Name :", "gradeName", SalaryGradeModel.class, binder);
        TextArea notes = UIComponent.getTextAreaFull("Notes :", "notes", SalaryGradeModel.class, binder);
        TextField midAmount = UIComponent.getGridBigDecimalTextField("Mid Amount :", "midAmount", SalaryGradeModel.class, binder);
        TextField endAmount = UIComponent.getGridBigDecimalTextField("End Amount :", "endAmount", SalaryGradeModel.class, binder);
        TextField startAmount = UIComponent.getGridBigDecimalTextField("Start Amount :", "startAmount", SalaryGradeModel.class, binder);
        TextField currentAmount = UIComponent.getGridBigDecimalTextField("Current Amount :", "currentAmount", SalaryGradeModel.class, binder);

        //ComboBox Fields
        final ComboBox currencyId = UIComboBox.getComboBox("Currency :", "currencyId", SalaryGradeModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Currency> currencies = UtilFacade.currencyServices.findAll();
                for (Currency currency : currencies) {
                    comboBox.addItem(currency.getId());
                    comboBox.setItemCaption(currency.getId(), currency.getName());
                }
            }
        });


        // Create a field group and use it to bind the fields in the layout
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        // First ROW
        grid.addComponent(gradeName, 0, 0);
        grid.addComponent(currentAmount, 1, 0);
        grid.addComponent(startAmount, 2, 0);

        //Second ROW
        grid.addComponent(midAmount, 0, 1);
        grid.addComponent(endAmount, 1, 1);
        grid.addComponent(currencyId, 2, 1);

        grid.addComponent(notes, 0, 3, 2, 3);


        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 4, 2, 4);
        grid.addComponent(buttons, 0, 5, 2, 5);

        addComponent(grid);
    }
}
