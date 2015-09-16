package hashwork.client.content.system.positions;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/18.
 */
public class PositionsMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;

    public PositionsMenu(MainLayout main, String tab) {
        this.main = main;

    }
}
