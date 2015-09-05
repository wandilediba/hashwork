package hashwork.client.header;

import com.vaadin.server.FileResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import hashwork.client.content.MainLayout;

import java.io.File;

/**
 * Created by hashcode on 2015/08/16.
 */
public class Header extends VerticalLayout {
    private final MainLayout main;
    private Window notifications;
    private Window userProfile;
    public Button home = new Button();
    public Button notify = new Button();
    public Button user = new Button();

    public Header(MainLayout main) {
        this.main = main;
        setMargin(true);
        setSizeFull();
        setSpacing(true);
        addComponent(getHeaderPanel());
//        addListener();
//        refreshNotification();

    }

    private Panel getHeaderPanel() {
        final Panel headerPanel = new Panel();
        headerPanel.setSizeFull();
        headerPanel.setHeight(50.0f, Unit.PIXELS);
        headerPanel.addStyleName(ValoTheme.PANEL_BORDERLESS);
        headerPanel.setContent(getLayout());
        return headerPanel;
    }

    private HorizontalLayout getLayout() {
        final HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(true);
        layout.setSizeFull();

        Component logo = getLogo();
        layout.addComponent(logo);
        layout.setComponentAlignment(logo, Alignment.MIDDLE_LEFT);

        final HorizontalLayout barMenu = new HorizontalLayout();
        barMenu.setSpacing(true);

        barMenu.addComponent(getBar());
        final TextField textField = getSearch();
        barMenu.addComponent(user);
        barMenu.addComponent(textField);
        layout.addComponent(barMenu);
        layout.setComponentAlignment(barMenu, Alignment.MIDDLE_RIGHT);

        return layout;
    }

    private Component getLogo() {
        final HorizontalLayout logo = new HorizontalLayout();
        FileResource resource = new FileResource(
                new File("src/main/webapp/VAADIN/themes/dashboard/img/app-icon.png"));
        Image logoImage = new Image(null, resource);
        logoImage.addStyleName("logo-header-image");
        logoImage.setHeight(50.0f, Unit.PIXELS);
        logoImage.setWidth(300.0f, Unit.PERCENTAGE);
        logo.addComponent(logoImage);
        Responsive.makeResponsive(logo);
        return logo;
    }

    private TextField getSearch() {

        final TextField searchBox = new TextField();
        searchBox.setIcon(FontAwesome.SEARCH);
        searchBox.setInputPrompt("Search");
        searchBox.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
        searchBox.addStyleName(ValoTheme.TEXTAREA_SMALL);
        return searchBox;
    }

    private HorizontalLayout getBar() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(false);
        home.setCaption("Home");
        home.setDescription("Home Page");
        home.setIcon(FontAwesome.HOME);
        home.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        home.addStyleName(ValoTheme.BUTTON_SMALL);

        user.setCaption("John Doe ");
        user.setDescription("Your user name)");
        user.setIcon(FontAwesome.USER);
        user.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        user.addStyleName(ValoTheme.BUTTON_SMALL);

        notify.addStyleName("notifications");
        notify.addStyleName("unread");
        notify.setIcon(new FileResource(
                new File("src/main/webapp/VAADIN/themes/dashboard/img/notifications.png")));
        notify.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        notify.addStyleName(ValoTheme.BUTTON_SMALL);

        layout.addComponent(home);
        layout.addComponent(notify);


        return layout;
    }

}
