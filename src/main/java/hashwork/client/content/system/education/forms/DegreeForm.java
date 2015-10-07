package hashwork.client.content.system.education.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import hashwork.app.facade.EducationFacade;
import hashwork.app.util.fields.ButtonsHelper;
import hashwork.app.util.fields.UIComboBoxHelper;
import hashwork.app.util.fields.UIComponentHelper;
import hashwork.client.content.system.education.model.DegreeModel;
import hashwork.domain.ui.education.EducationType;

import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by zamzam on 2015/10/06.
 */
public class DegreeForm extends FormLayout {
    private final DegreeModel bean;
    public final BeanItem<DegreeModel> item;
    public final FieldGroup binder;
    
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    
    public DegreeForm(){
        bean = new DegreeModel();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);

        final UIComponentHelper UIComponent = new UIComponentHelper();
        final UIComboBoxHelper UIComboBox = new UIComboBoxHelper();

       //TextField ç = UIComponent.getTextField("Education Type ID :", "educationTypeId", DegreeModel.class, binder);
        //ComboBox Fields
        final ComboBox educationTypeId = UIComboBox.getComboBox("Education Type ID :", "educationTypeId", DegreeModel.class, binder, new Consumer<ComboBox>() {
            public void accept(ComboBox comboBox) {
                Set<EducationType> educationType = EducationFacade.educationTypeService.findAll();
                for (EducationType educType : educationType) {
                    comboBox.addItem(educType.getId());
                    comboBox.setItemCaption(educType.getId(), educType.getName());
                }
            }
        });
        TextField studyField = UIComponent.getTextField("Study Field :", "studyField", DegreeModel.class, binder);
        TextField degreeName = UIComponent.getTextField("Degree Name :", "degreeName", DegreeModel.class, binder);

        addComponent(educationTypeId);
        addComponent(studyField);
        addComponent(degreeName);

        HorizontalLayout buttons = ButtonsHelper.getButtons(save, edit, cancel, update, delete);
        buttons.setSizeFull();
        addComponent(buttons);
    }
}
