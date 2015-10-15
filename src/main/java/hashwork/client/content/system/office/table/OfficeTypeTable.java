package hashwork.client.content.system.office.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.OfficeFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.office.OfficeType;

import java.util.Set;

/**
 * Created by zamzam on 2015/10/07.
 */
public class OfficeTypeTable extends Table {
    private final MainLayout main;

    public OfficeTypeTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Office Type", String.class, null);


        // Add Data Columns
        Set<OfficeType> officeTypes = OfficeFacade.officeTypeService.findAll();
        for (OfficeType officeType : officeTypes) {
            addItem(new Object[]{officeType.getName()}, officeType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
