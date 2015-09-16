package hashwork.client.content.users;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/17.
 */
public class UserManagementMenu extends VerticalLayout {
    private final MainLayout main;
    private TabSheet tab;

    public UserManagementMenu(MainLayout main, String tab) {
        this.main = main;

    }
}
