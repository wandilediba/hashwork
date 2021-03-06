package hashwork.client.content.system.utilities.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.util.Funder;

import java.util.Set;

/**
 * Created by hashcode on 2015/10/12.
 */
public class FunderTable extends Table {

    private final MainLayout main;

    public FunderTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Funder Name", String.class, null);
        addContainerProperty("Cost Center", String.class, null);
        addContainerProperty("City", String.class, null);
        addContainerProperty("Contact Number", String.class, null);
        addContainerProperty("Postal  Address", String.class, null);
        addContainerProperty("Physical Address", String.class, null);
        addContainerProperty("Postal Code", String.class, null);


        // Add Data Columns
        Set<Funder> funders = UtilFacade.funderService.findAll();
        for (Funder funder : funders) {
            addItem(new Object[]{funder.getTrainingFunderName(),
                    funder.getCostCenter(),
                    funder.getCityId(),
                    funder.getLocationContactId(),
                    funder.getLocationContactId(),
                    funder.getLocationContactId(),
                    funder.getLocationContactId()}, funder.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
