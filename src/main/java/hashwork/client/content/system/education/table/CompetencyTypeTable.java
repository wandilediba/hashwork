package hashwork.client.content.system.education.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.EducationFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.education.CompetencyType;

import java.util.Set;

/**
 * Created by zamzam on 2015/10/06.
 */
public class CompetencyTypeTable extends Table {
    private final MainLayout main;
    public CompetencyTypeTable(MainLayout main){
        this.main = main;
        setSizeFull();

        addContainerProperty("Name", String.class,null);

        Set<CompetencyType>competencyTypes = EducationFacade.competencyTypeService.findAll();
        for(CompetencyType competencyType:competencyTypes){
            addItem(new Object[]{competencyType.getName()}, competencyType.getId());
        }
        setNullSelectionAllowed(false);
        setSelectable(true);
        setImmediate(true);

    }

}
