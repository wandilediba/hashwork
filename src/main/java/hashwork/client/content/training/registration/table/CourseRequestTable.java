package hashwork.client.content.training.registration.table;

import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.Reindeer;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.CourseRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hashcode on 2015/10/08.
 */
public class CourseRequestTable extends Table {

    private final MainLayout main;

    public CourseRequestTable(MainLayout main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Request Name", String.class, null);
        addContainerProperty("Date Requested", Date.class, null);
        addContainerProperty("Prefferd Start Date", Date.class, null);
        addContainerProperty("Preffered End Date", Date.class, null);
        addContainerProperty("Status", String.class, null);
        addContainerProperty("Details", Button.class, null);


        // Add Data Columns
        List<CourseRequest> courseRequests = TrainingFacade.getCourseRequestService().findAll();
        for (CourseRequest courseRequest : courseRequests) {

            Button detailsButton = new Button("Details", new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                }
            });
            detailsButton.setStyleName(Reindeer.BUTTON_LINK);
            addItem(new Object[]{courseRequest.getRequestName(),
                    courseRequest.getRequestedDate(),
                    courseRequest.getPrefferedStart(),
                    courseRequest.getPreferredEnd(),
                    courseRequest.getStatus(),
                    detailsButton}, courseRequest.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);

        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }

    @Override
    protected String formatPropertyValue(Object rowId, Object colId, Property<?> property) {
        // Format by property type
        if (property.getType() == Date.class) {
            SimpleDateFormat df =
                    new SimpleDateFormat("EEE MMM dd ");
            return df.format((Date) property.getValue());
        }

        return super.formatPropertyValue(rowId, colId, property);
    }
}
