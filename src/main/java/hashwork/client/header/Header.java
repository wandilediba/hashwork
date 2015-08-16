package hashwork.client.header;

import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.MainLayout;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Header extends VerticalLayout {
    private final MainLayout main;

    public Header(MainLayout main) {
        this.main = main;
    }
}
