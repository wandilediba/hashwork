package hashwork.client.sidebar.trees;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/17.
 */
public class HomeTree extends Tree implements ItemClickEvent.ItemClickListener {
    private final MainLayout main;
    private static final String LANDING_TAB = "LANDING";

    public HomeTree(MainLayout main) {
        this.main = main;
    }

    @Override
    public void itemClick(ItemClickEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
