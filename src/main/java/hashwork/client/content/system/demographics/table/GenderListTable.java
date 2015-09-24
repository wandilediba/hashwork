package hashwork.client.content.system.demographics.table;

import com.vaadin.ui.Table;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.demographics.GenderList;
import hashwork.services.ui.demographics.GenderListService;
import hashwork.services.ui.demographics.Impl.GenderListServiceImpl;

import java.util.Set;

/**
 * Created by hashcode on 2015/08/18.
 */
public class GenderListTable extends Table {
    private final MainLayout main;
    private final GenderListService genderListService = new GenderListServiceImpl();

    public GenderListTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Gender ", String.class, null);

        // Add Data Columns
        Set<GenderList> genderLists = genderListService.findAll();
        for (GenderList genderList : genderLists) {
            // addItem(new Object[]{genderList.getGender()}, genderList.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
