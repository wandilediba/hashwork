package hashwork.client.content.training.employee.views;

import com.vaadin.data.Property;
import com.vaadin.ui.VerticalLayout;
import hashwork.client.content.training.employee.table.RejectedRequestCompetenciesTable;

/**
 * Created by hashcode on 2015/10/08.
 */
public class RejectedRequestTab extends VerticalLayout implements
        Property.ValueChangeListener {

    private final HashWorkMain main;

    private final RejectedRequestCompetenciesTable table;

    public RejectedRequestTab(HashWorkMain app) {
        main = app;

        table = new RejectedRequestCompetenciesTable(main);
        setSizeFull();
        addComponent(table);
        addListeners();
    }


    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == table) {

        }
    }

    private void getHome() {
        main.content.setSecondComponent(new EmployeeTrainingMenu(main, "REJECTED"));
    }

    private void addListeners() {

        table.addValueChangeListener((ValueChangeListener) this);
    }
}
