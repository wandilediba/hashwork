package hashwork.client.content.system.utilities;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/18.
 */
public class UtilitiesMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;

    public UtilitiesMenu(MainLayout main, String tab) {
        this.main = main;

    }
}

