package hashwork.client.content.system.utilities.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.UtilFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.util.DisciplineActionTypeList;

import java.util.Set;

/**
 * Created by hashcode on 2015/10/12.
 */
public class DisciplineActionTypeListTable extends Table {


    private final MainLayout main;

    public DisciplineActionTypeListTable(MainLayout main) {
        this.main = main;
        setSizeFull();

//    private String accidentName;
//    private String description;

        addContainerProperty("Action  Name", String.class, null);
        addContainerProperty(" Action Description", String.class, null);

        // Add Data Columns
        Set<DisciplineActionTypeList> accActionTypeLists = UtilFacade.disciplineActionTypeListService.findAll();
        for (DisciplineActionTypeList actionTypeList : accActionTypeLists) {
            addItem(new Object[]{actionTypeList.getName(), actionTypeList.getDescription()}, actionTypeList.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
