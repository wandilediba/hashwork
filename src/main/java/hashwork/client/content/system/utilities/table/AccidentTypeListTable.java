package hashwork.client.content.system.utilities.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.util.AccidentTypeList;

import java.util.Set;

/**
 * Created by hashcode on 2015/10/12.
 */
public class AccidentTypeListTable extends Table {


    private final MainLayout main;

    public AccidentTypeListTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Accident Type Name", String.class, null);
        addContainerProperty("Accident Description", String.class, null);

        // Add Data Columns
        Set<AccidentTypeList> accidentTypeLists = UtilFacade.accidentTypeListService.findAll();
        for (AccidentTypeList accidentTypeList : accidentTypeLists) {
            addItem(new Object[]{accidentTypeList.getName(), accidentTypeList.getDescription()}, accidentTypeList.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
