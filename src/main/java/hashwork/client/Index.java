package hashwork.client;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import hashwork.client.content.login.LoginView;

/**
 * Created by hashcode on 2015/08/16.
 */
@Theme("tests-valo")
@SpringUI(path = "")
public class Index extends UI {
    @Override

    protected void init(VaadinRequest request) {
        getPage().setTitle("Login Page");
        Responsive.makeResponsive(this);
        setContent(new LoginView(this));
        setOverlayContainerLabel(" Events");

    }
}
