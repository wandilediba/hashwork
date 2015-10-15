package hashwork.services.ui.training;

import hashwork.domain.ui.training.CompetencyRequestAggregate;

import java.util.Set;

/**
 * Created by garran on 2015/09/14.
 */
public interface CompetencyRequestAggregateService {
    public Set<CompetencyRequestAggregate> getPendingRequests();

    public void aprroveRequests(String id);

    public void rejectRequests(String id);

    public void fullfillRequests(String id);

    public Set<String> getRequestorsIds(String id);

    public Set<CompetencyRequestAggregate> getApprovedRequests();

    public Set<CompetencyRequestAggregate> getFullfilledRequests();

    public Set<CompetencyRequestAggregate> getRejectedRequests();

}
