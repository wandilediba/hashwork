package hashwork.client.sidebar;

import com.vaadin.ui.Accordion;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/16.
 */
public class SideBar extends Accordion {
    private final MainLayout main;

    public SideBar(MainLayout main) {
        this.main = main;
    }
}
