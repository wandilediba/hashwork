package hashwork.client.content;

import com.vaadin.server.Responsive;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.Index;
import hashwork.client.content.home.LandindPageView;
import hashwork.client.footer.Footer;
import hashwork.client.header.Header;
import hashwork.client.sidebar.SideBar;

/**
 * Created by hashcode on 2015/08/16.
 */
public class MainLayout extends VerticalLayout {

    private final Index main;
    public final HorizontalSplitPanel content = new HorizontalSplitPanel();

    public MainLayout(Index main) {

        this.main = main;
        Responsive.makeResponsive(this);
        content.setMaxSplitPosition(25, Unit.PERCENTAGE);
        content.setLocked(true);
        content.setFirstComponent(new SideBar(this));
        content.setSecondComponent(new LandindPageView(this));
        addComponent(new Header(this));
        addComponent(content);
        addComponent(new Footer());

    }

}
