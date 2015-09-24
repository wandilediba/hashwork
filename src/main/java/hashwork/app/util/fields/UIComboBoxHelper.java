package hashwork.app.util.fields;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.ComboBox;
import hashwork.app.facade.LocationFacade;
import hashwork.domain.ui.location.Location;
import hashwork.domain.ui.location.LocationType;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by hashcode on 2015/09/07.
 */
public class UIComboBoxHelper<T> implements Serializable {
    public ComboBox getUploadComboBox(String fieldText, String fieldName, Class<T> fieldClass, FieldGroup binder) {
        ComboBox comboBox = new ComboBox(fieldText);
        comboBox.addValidator(new BeanValidator(fieldClass, fieldName));
        comboBox.setImmediate(true);
        comboBox.setNullSelectionAllowed(false);
        comboBox.setWidth(250, Sizeable.Unit.PIXELS);
        binder.bind(comboBox, fieldName);
        return comboBox;
    }

    public ComboBox getEmptyComboBox(String fieldText, String fieldName, Class<T> fieldClass, FieldGroup binder) {
        ComboBox comboBox = new ComboBox(fieldText);

        comboBox.addValidator(new BeanValidator(fieldClass, fieldName));
        comboBox.setImmediate(true);
        comboBox.setNullSelectionAllowed(false);
        comboBox.setWidth(250, Sizeable.Unit.PIXELS);
        binder.bind(comboBox, fieldName);
        return comboBox;
    }

    public ComboBox getLocationComboBox(String fieldText, String fieldName, Class<T> fieldClass, FieldGroup binder) {
        ComboBox comboBox = new ComboBox(fieldText);
        Set<Location> locations = LocationFacade.locationService.findAll();

        //  Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
        for (Location location : locations) {
            comboBox.addItem(location.getId());
            comboBox.setItemCaption(location.getId(), location.getName());
        }
        comboBox.addValidator(new BeanValidator(fieldClass, fieldName));
        comboBox.setImmediate(true);
        comboBox.setNullSelectionAllowed(false);
        comboBox.setWidth(250, Sizeable.Unit.PIXELS);
        binder.bind(comboBox, fieldName);
        return comboBox;
    }

    public ComboBox getLocationTypeComboBox(String fieldText, String fieldName, Class<T> fieldClass, FieldGroup binder) {
        ComboBox comboBox = new ComboBox(fieldText);
        Set<LocationType> locationTypeList = LocationFacade.locationTypeService.findAll();

        //  Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
        for (LocationType locationType : locationTypeList) {
            comboBox.addItem(locationType.getId());
            comboBox.setItemCaption(locationType.getId(), locationType.getName());
        }
        comboBox.addValidator(new BeanValidator(fieldClass, fieldName));
        comboBox.setImmediate(true);
        comboBox.setNullSelectionAllowed(false);
        comboBox.setWidth(250, Sizeable.Unit.PIXELS);
        binder.bind(comboBox, fieldName);
        return comboBox;
    }


}
