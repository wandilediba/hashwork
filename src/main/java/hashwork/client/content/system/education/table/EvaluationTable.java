package hashwork.client.content.system.education.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.EducationFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.education.Evaluation;

import java.util.Set;

/**
 * Created by zamzam on 2015/10/06.
 */
public class EvaluationTable extends Table {

    private final MainLayout main;

    public EvaluationTable(MainLayout main){
        this.main = main;
        setSizeFull();

        addContainerProperty("Name", String.class, null);

        Set<Evaluation> evaluations = EducationFacade.evaluationService.findAll();
        for (Evaluation evaluation:evaluations){
            addItem(new Object[]{evaluation.getName()}, evaluation.getId());
        }

        setNullSelectionAllowed(false);

        setSelectable(true);

        setImmediate(true);
    }
}
