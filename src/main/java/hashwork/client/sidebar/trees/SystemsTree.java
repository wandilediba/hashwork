package hashwork.client.sidebar.trees;

import com.vaadin.event.ItemClickEvent;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/17.
 */
public class SystemsTree implements ItemClickEvent.ItemClickListener {
    private final MainLayout main;
    private static final String LANDING_TAB = "LANDING";

    public SystemsTree(MainLayout main) {
        this.main = main;
    }
    @Override
    public void itemClick(ItemClickEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
