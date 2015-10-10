package hashwork.client.content.system.education.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.EducationFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.education.EducationType;

import java.util.Set;

/**
 * Created by zamzam on 2015/10/06.
 */
public class EducationTypeTable extends Table{
    private final MainLayout main;

    public EducationTypeTable(MainLayout main){
        this.main = main;
        setSizeFull();

        addContainerProperty("Name", String.class, null);

        //add Data Columns
        Set<EducationType> educationTypes = EducationFacade.educationTypeService.findAll();
        for(EducationType educationType : educationTypes){
            addItem(new Object[]{educationType.getName()}, educationType.getId());
        }

        //Allow selecting items from table
        setNullSelectionAllowed(false);

        setSelectable(true);

        setImmediate(true);
    }

}
