package hashwork.client.content.system.office.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.OfficeFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.office.Department;

import java.util.Set;

/**
 * Created by zamzam on 2015/10/07.
 */
public class DepartmentTable extends Table {
    private final MainLayout main;

    public DepartmentTable(MainLayout main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Name", String.class, null);
        addContainerProperty("Description", String.class, null);
        addContainerProperty("isActive", boolean.class, null);
        addContainerProperty("Date Established", String.class, null);


        // Add Data Columns
        Set<Department> departments = OfficeFacade.departmentService.findAll();
        for (Department department : departments) {
            addItem(new Object[]{department.getName(),
            department.getDescription(),
            department.isActive(),
            department.getDateEstablished()}, department.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);


    }
}
