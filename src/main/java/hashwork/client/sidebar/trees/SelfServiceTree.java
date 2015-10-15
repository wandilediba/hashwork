package hashwork.client.sidebar.trees;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/17.
 */
public class SelfServiceTree extends Tree implements ItemClickEvent.ItemClickListener {
    private final MainLayout main;
    private static final String LANDING_TAB = "LANDING";
    private static final String TRAINING_TAB = "Manage TRAINING";
    private static final String APPLICATIONS_TAB = "Request APPLICATIONS";
    private static final String PAYSLIPS_TAB = "Your PAYSLIPS";

    public SelfServiceTree(MainLayout main) {
        this.main = main;
        addItem(APPLICATIONS_TAB);
        addItem(PAYSLIPS_TAB);
        addItem(TRAINING_TAB);
    }
    @Override
    public void itemClick(ItemClickEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
