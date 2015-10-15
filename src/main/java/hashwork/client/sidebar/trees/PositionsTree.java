package hashwork.client.sidebar.trees;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/17.
 */
public class PositionsTree extends Tree implements ItemClickEvent.ItemClickListener {
    private final MainLayout main;
    public static final Object ACTIVE_POSITIONS = "Active POSITIONS";
    public static final Object INACTIVE_POSITIONS = "Inactive POSITIONS";
    private static final String LANDING_TAB = "LANDING";

    public PositionsTree(MainLayout main) {
        this.main = main;
        addItem(ACTIVE_POSITIONS);
        addItem(INACTIVE_POSITIONS);
        //Add Listeners
        addItemClickListener((ItemClickEvent.ItemClickListener) this);
    }
    @Override
    public void itemClick(ItemClickEvent event) {
        Object itemId = event.getItemId();
        if (itemId != null) {
            if (ACTIVE_POSITIONS.equals(itemId)) {
                activePositionsView();
            } else if (INACTIVE_POSITIONS.equals(itemId)) {
                inactivePositionsView();
            }
        }
    }

    private void activePositionsView() {
//        main.content.setSecondComponent(new ActivePositionsMenu(main, LANDING_TAB));
    }

    private void inactivePositionsView() {
//        main.content.setSecondComponent(new InactivePositionsMenu(main, LANDING_TAB));
    }
}
