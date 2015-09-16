package hashwork.client.content.system.locations.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.LocationFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.location.AddressType;

import java.util.Set;

/**
 * Created by hashcode on 2015/09/07.
 */
public class AddressTypeTable extends Table {


    private final MainLayout main;

    public AddressTypeTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Address Type", String.class, null);


        // Add Data Columns
        Set<AddressType> addressTypes = LocationFacade.addressTypeService.findAll();
        for (AddressType addressType : addressTypes) {
            addItem(new Object[]{addressType.getAddressTypeName()}, addressType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}