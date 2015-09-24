package hashwork.client.content.system.positions.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.PositionFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.position.DepartureReason;

import java.util.Set;

/**
 * Created by hashcode on 2015/09/16.
 */
public class DepartureReasonTable extends Table {


    private final MainLayout main;

    public DepartureReasonTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Depature Reason", String.class, null);
        addContainerProperty("Description", String.class, null);

        // Add Data Columns
        Set<DepartureReason> departureReasons = PositionFacade.departureReasonService.findAll();
        for (DepartureReason departureReason : departureReasons) {
            addItem(new Object[]{
                            departureReason.getReasonName(),
                            departureReason.getDescription()
                    },
                    departureReason.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}