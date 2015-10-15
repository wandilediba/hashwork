package hashwork.client.sidebar.trees;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import hashwork.client.content.MainLayout;
import hashwork.client.content.users.UserManagementMenu;

/**
 * Created by hashcode on 2015/08/17.
 */
public class ProfileTree extends Tree implements ItemClickEvent.ItemClickListener {
    private final MainLayout main;
    public static final Object USERS_PROFILE = "User PROFILE";
    public static final Object CHANGE_PASSSWORD = "Change PASSWORD";
    private static final String LANDING_TAB = "LANDING";

    public ProfileTree(MainLayout main) {
        this.main = main;
        addItem(USERS_PROFILE);
        addItem(CHANGE_PASSSWORD);

        //Add Listeners
        addItemClickListener((ItemClickEvent.ItemClickListener) this);
    }

    @Override
    public void itemClick(ItemClickEvent event) {
        Object itemId = event.getItemId();
        if (itemId != null) {
            if (USERS_PROFILE.equals(itemId)) {
                manageUsersView();
            }
        }
    }

    private void manageUsersView() {
        main.content.setSecondComponent(new UserManagementMenu(main, LANDING_TAB));

    }
}
