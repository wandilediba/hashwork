package hashwork.client.content.system.positions.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.PositionFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.position.PositionType;

import java.util.Set;

/**
 * Created by hashcode on 2015/09/16.
 */
public class PositionTypeTable extends Table {


    private final MainLayout main;

    public PositionTypeTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Name Type", String.class, null);

        // Add Data Columns
        Set<PositionType> positionTypes = PositionFacade.positionTypeService.findAll();
        for (PositionType positionType : positionTypes) {
            addItem(new Object[]{positionType.getName()}, positionType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}