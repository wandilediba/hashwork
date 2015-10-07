package hashwork.client.content.system.education.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.facade.EducationFacade;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.education.model.CompetencyModel;
import hashwork.domain.ui.education.Competency;
import hashwork.domain.ui.education.CompetencyType;

import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by zamzam on 2015/10/06.
 */
public class CompetencyForm extends FormLayout {
    private final CompetencyModel bean;
    public final BeanItem<CompetencyModel> item;
    public final FieldGroup binder;

    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public CompetencyForm(){
        bean = new CompetencyModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);


        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

        /* final ComboBox currency = UIComboBox.getComboBox("Currency :", "currencyId", BenefitTypeModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Currency> currencies = UtilFacade.currencyServices.findAll();
                for (Currency currency : currencies) {
                    comboBox.addItem(currency.getId());
                    comboBox.setItemCaption(currency.getId(), currency.getName());
                }
            }
        });*/

        //ComboBox Fields
        final ComboBox competencyTypeId = UIComboBox.getComboBox("Competency ID :", "competencyTypeId", CompetencyModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<Competency> competencies = EducationFacade.competencyService.findAll();
                for (Competency competency : competencies) {
                    comboBox.addItem(competency.getId());
                    comboBox.setItemCaption(competency.getId(), competency.getName());
                }
            }
        });

      //  TextField competencyTypeId = UIComponent.getTextField("competency Type ID :", "competencyTypeId", CompetencyModel.class, binder);
        TextField name = UIComponent.getTextField("Competency Name :", "name", CompetencyModel.class, binder);
        TextArea notes = UIComponent.getGridTextArea("Competency Notes :", "notes", CompetencyModel.class, binder);

        addComponent(competencyTypeId);
        addComponent(name);
        addComponent(notes);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
