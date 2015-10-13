package hashwork.client.content.system.utilities.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.util.Status;

import java.util.Set;

/**
 * Created by hashcode on 2015/10/12.
 */
public class StatusTable extends Table {


    private final MainLayout main;

    public StatusTable(MainLayout main) {
        this.main = main;
        setSizeFull();
//    private String statusType;
//    private String statusValues;

        addContainerProperty("Status Type", String.class, null);
        addContainerProperty("Status Value", String.class, null);

        // Add Data Columns
        Set<Status> statuses = UtilFacade.statusService.findAll();
        for (Status status : statuses) {
            addItem(new Object[]{status.getStatusType(), status.getStatusValues()}, status.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }
}
