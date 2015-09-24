package hashwork.app.util.fields;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;

/**
 * Created by hashcode on 2015/09/07.
 */
public class DialobBoxWindow extends Window {
    public Button btnYesDialog = new Button("Yes");
    public Button btnNoDialog = new Button("No");
    public Button btnCancelDialog = new Button("Cancel");
    public Button btnDeleteDialog = new Button("Delete");
    public Button btnConfirmDialog = new Button("Confirm");
    public Button btnIgnoreDialog = new Button("Ignore");
    public Button btnOkDialog = new Button("OK");

    /**
     * @param windowTitle
     */
    public DialobBoxWindow(String windowTitle) {
        // Create a sub-window and set the content

        setClosable(false);

        // Set window size.
        setHeight("150px");
        setWidth("300px");

// Set window position.
        setPositionX(200);
        setPositionY(50);
        setModal(true);
        // Center it in the browser window
        //  dialogBox.center();
    }


    public HorizontalLayout getOKButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        btnOkDialog.setSizeFull();
        buttons.addComponent(btnOkDialog);
        return buttons;
    }

    public HorizontalLayout getOKCancelButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        btnOkDialog.setSizeFull();
        btnCancelDialog.setSizeFull();
        buttons.addComponent(btnOkDialog);
        buttons.addComponent(btnCancelDialog);
        return buttons;
    }

    public HorizontalLayout getYesNoButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        btnYesDialog.setSizeFull();
        btnNoDialog.setSizeFull();
        buttons.addComponent(btnYesDialog);
        buttons.addComponent(btnNoDialog);
        return buttons;
    }

    public HorizontalLayout getYesNoCancelButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        btnYesDialog.setSizeFull();
        btnNoDialog.setSizeFull();
        btnCancelDialog.setSizeFull();
        buttons.addComponent(btnYesDialog);
        buttons.addComponent(btnNoDialog);
        buttons.addComponent(btnCancelDialog);
        return buttons;
    }
}
