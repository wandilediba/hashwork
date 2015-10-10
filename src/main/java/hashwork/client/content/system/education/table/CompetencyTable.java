package hashwork.client.content.system.education.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.EducationFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.education.Competency;

import java.util.Set;

/**
 * Created by zamzam on 2015/10/06.
 */
public class CompetencyTable extends Table{
    private final MainLayout main;
    public CompetencyTable(MainLayout main){
        this.main = main;
        setSizeFull();

        addContainerProperty("Name", String.class,null);
        addContainerProperty("Notes",String.class,null);

        Set<Competency> competencies = EducationFacade.competencyService.findAll();
        for(Competency competency:competencies){
            addItem(new Object[]{competency.getName(),
            competency.getNotes(),
            getCompetencyTypeId(competency.getCompetencyTypeId())}, competency.getId());
        }

        setNullSelectionAllowed(false);
        setSelectable(true);
        setImmediate(true);
    }

    private String getCompetencyTypeId(String competencyTypeId){
        Competency competency = EducationFacade.competencyService.findById(competencyTypeId);
        return competency.getCompetencyTypeId();
    }
}
