package hashwork.client.content.system.training.table;

import com.vaadin.ui.Table;
import hashwork.app.facade.TrainingFacade;
import hashwork.client.content.MainLayout;
import hashwork.domain.ui.training.CourseFundingSource;

import java.util.Set;

/**
 * Created by sihle on 2015/10/08.
 */
public class CourseFundingSourceTable extends Table {

    private final MainLayout main;

    public CourseFundingSourceTable(MainLayout main){
        this.main = main;
        setSizeFull();

        addContainerProperty("Course Id", String.class, null);
        addContainerProperty("Funder Id", String.class, null);
        addContainerProperty("Amount", String.class, null);
        addContainerProperty("Currency Id", String.class, null);

        Set<CourseFundingSource> courseFundingSources = TrainingFacade.courseFundingSourceService.findAll();
        for(CourseFundingSource courseFundingSource: courseFundingSources){
            addItem(new Object[]{courseFundingSource.getCourseId(),
                    courseFundingSource.getFunderId(),
                    courseFundingSource.getAmount(),
                    courseFundingSource.getCurrencyId()},
                    courseFundingSource.getId());
        }


    }
}