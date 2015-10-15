package hashwork.client.sidebar.trees;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/17.
 */
public class ReportsTree extends Tree implements ItemClickEvent.ItemClickListener {
    private final MainLayout main;
    private static final String LANDING_TAB = "LANDING";
    private static final String POSITION_TAB = "Job REPORTS";
    private static final String TRAINING_TAB = "Training REPORTS";
    private static final String APPLICATIONS_TAB = "Job Application REPORTS";
    private static final String DECISION_TAB = "Decision REPORTS";

    public ReportsTree(MainLayout main) {
        this.main = main;
        addItem(POSITION_TAB);
        addItem(TRAINING_TAB);
        addItem(APPLICATIONS_TAB);
        addItem(DECISION_TAB);
    }

    @Override
    public void itemClick(ItemClickEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
