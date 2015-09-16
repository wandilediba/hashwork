package hashwork.client.content.system.locations.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.LocationFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.location.RegistrationBody;

import java.util.Date;
import java.util.Set;

/**
 * Created by hashcode on 2015/09/07.
 */
public class RegistrationBodyTable extends Table {


    private final MainLayout main;

    public RegistrationBodyTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Name", String.class, null);
        addContainerProperty("Description", String.class, null);
        addContainerProperty("Core Activity", String.class, null);
        addContainerProperty("Active", String.class, null);
        addContainerProperty("Date ", Date.class, null);

        // Add Data Columns
        Set<RegistrationBody> registrationBodys = LocationFacade.registrationBodyService.findAll();
        for (RegistrationBody registrationBody : registrationBodys) {
            addItem(new Object[]{registrationBody.getName(),
                    registrationBody.getDescription(),
                    registrationBody.getCoreActivity(),
                    registrationBody.getActive(),
                    registrationBody.getAsOfDate()}, registrationBody.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}