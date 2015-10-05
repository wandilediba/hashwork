package hashwork.client.content.system.positions.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import hashwork.app.facade.PositionFacade;
import hashwork.app.facade.UtilFacade;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.positions.model.PositionSalarySourceModel;
import hashwork.domain.ui.position.Position;
import hashwork.domain.ui.util.Currency;
import hashwork.domain.ui.util.Funder;

import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by hashcode on 2015/09/16.
 */
public class PositionSalarySourceForm extends FormLayout {
    private final PositionSalarySourceModel bean;
    public final BeanItem<PositionSalarySourceModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public PositionSalarySourceForm() {
        bean = new PositionSalarySourceModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        // Define Fields
        // Text Fields
        TextField amount = UIComponent.getGridBigDecimalTextField("Amount :", "amount", PositionSalarySourceModel.class, binder);


        //ComboBox Fields
        final ComboBox positionId = UIComboBox.getComboBox("Position Title :", "positionId", PositionSalarySourceModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Position> positions = PositionFacade.positionService.findAll();
                for (Position position : positions) {
                    comboBox.addItem(position.getId());
                    comboBox.setItemCaption(position.getId(), position.getPositionTitle());
                }
            }
        });

        //ComboBox Fields
        final ComboBox funderId = UIComboBox.getComboBox("Funding Source :", "funderId", PositionSalarySourceModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Funder> funders = UtilFacade.funderService.findAll();
                for (Funder funder : funders) {
                    comboBox.addItem(funder.getId());
                    comboBox.setItemCaption(funder.getId(), funder.getTrainingFunderName());
                }
            }
        });

        //ComboBox Fields
        final ComboBox currencyId = UIComboBox.getComboBox("Currency :", "currencyId", PositionSalarySourceModel.class, binder, new Consumer<ComboBox>() {
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
        grid.addComponent(positionId, 0, 0);
        grid.addComponent(funderId, 0, 1);
        grid.addComponent(currencyId, 2, 0);

        //Second ROW
        grid.addComponent(amount, 1, 1);


        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        grid.addComponent(new Label("<hr/>", ContentMode.HTML), 0, 4, 2, 4);
        grid.addComponent(buttons, 0, 5, 2, 5);

        addComponent(grid);
    }
}
