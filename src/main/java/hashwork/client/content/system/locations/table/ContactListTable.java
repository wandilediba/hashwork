package hashwork.client.content.system.locations.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.LocationFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.location.ContactList;

import java.util.Set;

/**
 * Created by hashcode on 2015/09/07.
 */
public class ContactListTable extends Table {

    private final MainLayout main;

    public ContactListTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Contact List Name", String.class, null);


        // Add Data Columns
        Set<ContactList> locationTypes = LocationFacade.contactListService.findAll();
        for (ContactList locationType : locationTypes) {
            addItem(new Object[]{locationType.getName()}, locationType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}