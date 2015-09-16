package hashwork.client.footer;

import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Footer extends VerticalLayout {

    public Footer() {
        setSizeFull();
        this.addComponent(new Panel());
        addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);

    }
}