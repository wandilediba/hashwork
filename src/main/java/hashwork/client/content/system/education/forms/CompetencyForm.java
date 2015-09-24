package hashwork.client.content.system.education.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.education.model.CompetencyModel;
//import hashwork.services.ui.education.Impl.CompetencyServiceImpl;

/**
 * Created by sbm on 2015/09/23.
 */
public class CompetencyForm extends FormLayout {

    private final CompetencyModel bean;
    //private final CompetencyService competencyService = new CompetencyServiceImpl();
    public final BeanItem<CompetencyModel> item;
    public final FieldGroup binder;

    //Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public CompetencyForm() {
        bean = new CompetencyModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();


        TextField name = UIComponent.getTextField("Name :", "name", CompetencyModel.class, binder);
        TextField notes = UIComponent.getTextField("notes :", "notes", CompetencyModel.class, binder);

        //combo boxes

        ComboBox competencyTypeId = UIComboBox.getLocationComboBox("Competency Type :", "competencyTypeId", CompetencyModel.class, binder);
        addComponent(name);
        addComponent(competencyTypeId);
        addComponent(notes);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }



}
