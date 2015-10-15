package hashwork.client.sidebar.trees;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/17.
 */
public class EmployeesTree extends Tree implements ItemClickEvent.ItemClickListener {
    private final MainLayout main;
    public static final Object ORGANISATION_EMPLOYEES = "Manage EMPLOYEES";
    private static final String LANDING_TAB = "LANDING";

    public EmployeesTree(MainLayout main) {
        this.main = main;
        addItem(ORGANISATION_EMPLOYEES);

        //Add Listeners
        addItemClickListener((ItemClickEvent.ItemClickListener) this);
    }
    @Override
    public void itemClick(ItemClickEvent event) {
        Object itemId = event.getItemId();
        if (itemId != null) {
            if (ORGANISATION_EMPLOYEES.equals(itemId)) {
                employeesView();
            }
        }
    }

    private void employeesView() {
//        main.content.setSecondComponent(new EmployeeMenu(main, LANDING_TAB));
    }

}
