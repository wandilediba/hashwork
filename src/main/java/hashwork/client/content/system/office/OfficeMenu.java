package hashwork.client.content.system.office;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/18.
 */
public class OfficeMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;

    public OfficeMenu(MainLayout main, String tab) {
        this.main = main;

    }
}
