package hashwork.client.content.system.education;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/18.
 */
public class EducationMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;

    public EducationMenu(MainLayout main, String tab) {
        this.main = main;

    }
}
