package hashwork.client.content.system.locations;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/18.
 */
public class LocationMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;

    public LocationMenu(MainLayout main, String tab) {
        this.main = main;

    }
}

