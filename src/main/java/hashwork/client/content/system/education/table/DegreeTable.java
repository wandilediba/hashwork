package hashwork.client.content.system.education.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.EducationFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.education.Degree;
import hashwork.domain.ui.education.EducationType;

import java.util.Set;

/**
 * Created by zamzam on 2015/10/06.
 */
public class DegreeTable extends Table {

    private final MainLayout main;

    public DegreeTable(MainLayout main){
        this.main = main;
        setSizeFull();

        addContainerProperty("Study Field", String.class, null);
        addContainerProperty("Degree Name", String.class, null);

        Set<Degree> degrees = EducationFacade.degreeService.findAll();
        for(Degree degree:degrees){
            addItem(new Object[]{degree.getStudyField(),
            degree.getDegreeName(),
            getEducationType(degree.getEducationTypeId())}, degree.getId());
        }

        setNullSelectionAllowed(false);
        setSelectable(true);
        setImmediate(true);
    }

    private String getEducationType(String educationTypeId){
        Degree degree = EducationFacade.degreeService.findById(educationTypeId);
        return degree.getEducationTypeId();
    }
}
