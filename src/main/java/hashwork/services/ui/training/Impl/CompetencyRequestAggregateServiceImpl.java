package hashwork.services.ui.training.Impl;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import hashwork.client.content.training.util.CompetencyRequestStatus;
import hashwork.domain.ui.training.CompetencyRequest;
import hashwork.domain.ui.training.CompetencyRequestAggregate;
import hashwork.services.ui.training.CompetencyRequestAggregateService;
import hashwork.services.ui.training.CompetencyRequestService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by garran on 2015/09/14.
 */
public class CompetencyRequestAggregateServiceImpl implements CompetencyRequestAggregateService {


    private final CompetencyRequestService competencyRequestService = new CompetencyRequestServiceImpl();

    @Override
    public Set<CompetencyRequestAggregate> getPendingRequests() {
        Set<CompetencyRequest> requests = competencyRequestService
                .findAll()
                .parallelStream()
                .filter(req -> req.getStatus().equalsIgnoreCase(CompetencyRequestStatus.PENDING.name()))
                .collect(Collectors.toSet());
        Set<CompetencyRequestAggregate> set = getRecords(requests);
        return new HashSet<>(set);
    }

    @Override
    public void aprroveRequests(String id) {
        Set<CompetencyRequest> competencyRequests = competencyRequestService
                .findAll()
                .parallelStream()
                .filter(req -> req.getCompetencyId().equalsIgnoreCase(id))
                .filter(req -> req.getStatus().equalsIgnoreCase(CompetencyRequestStatus.PENDING.name()))
                .collect(Collectors.toSet());
        for (CompetencyRequest competencyRequest : competencyRequests) {
            CompetencyRequest updatedCompetencyRequest = new CompetencyRequest
                    .Builder()
                    .copy(competencyRequest)
                    .status(CompetencyRequestStatus.APPROVED.name())
                    .build();
            competencyRequestService.save(updatedCompetencyRequest);
        }
    }

    @Override
    public void fullfillRequests(String id) {

        Set<CompetencyRequest> competencyRequests = competencyRequestService
                .findAll()
                .parallelStream()
                .filter(req -> req.getCompetencyId().equalsIgnoreCase(id))
                .filter(req -> req.getStatus().equalsIgnoreCase(CompetencyRequestStatus.APPROVED.name()))
                .collect(Collectors.toSet());
        for (CompetencyRequest competencyRequest : competencyRequests) {
            CompetencyRequest updatedCompetencyRequest = new CompetencyRequest
                    .Builder()
                    .copy(competencyRequest)
                    .status(CompetencyRequestStatus.FULLFILLED.name())
                    .build();
            competencyRequestService.save(updatedCompetencyRequest);
        }
    }

    @Override
    public void rejectRequests(String id) {
        Set<CompetencyRequest> competencyRequests = competencyRequestService
                .findAll()
                .parallelStream()
                .filter(req -> req.getCompetencyId().equalsIgnoreCase(id))
                .filter(req -> req.getStatus().equalsIgnoreCase(CompetencyRequestStatus.PENDING.name()))
                .collect(Collectors.toSet());
        for (CompetencyRequest competencyRequest : competencyRequests) {
            CompetencyRequest updatedCompetencyRequest = new CompetencyRequest
                    .Builder()
                    .copy(competencyRequest)
                    .status(CompetencyRequestStatus.REJECTED.name())
                    .build();
            competencyRequestService.save(updatedCompetencyRequest);
        }

    }

    @Override
    public Set<CompetencyRequestAggregate> getApprovedRequests() {
        Set<CompetencyRequest> requests = competencyRequestService
                .findAll()
                .parallelStream()
                .filter(req -> req.getStatus().equalsIgnoreCase(CompetencyRequestStatus.APPROVED.name()))
                .collect(Collectors.toSet());
        Set<CompetencyRequestAggregate> set = getRecords(requests);

        return new HashSet<CompetencyRequestAggregate>(set);
    }

    @Override
    public Set<CompetencyRequestAggregate> getFullfilledRequests() {
        Set<CompetencyRequest> requests = competencyRequestService
                .findAll()
                .parallelStream()
                .filter(req -> req.getStatus().equalsIgnoreCase(CompetencyRequestStatus.FULLFILLED.name()))
                .collect(Collectors.toSet());
        Set<CompetencyRequestAggregate> set = getRecords(requests);

        return new HashSet<>(set);
    }

    @Override
    public Set<CompetencyRequestAggregate> getRejectedRequests() {
        Set<CompetencyRequest> requests = competencyRequestService
                .findAll()
                .parallelStream()
                .filter(req -> req.getStatus().equalsIgnoreCase(CompetencyRequestStatus.REJECTED.name()))
                .collect(Collectors.toSet());
        Set<CompetencyRequestAggregate> set = getRecords(requests);
        return new HashSet<>(set);
    }

    private Set<CompetencyRequestAggregate> getRecords(Set<CompetencyRequest> requests) {
        Multiset<String> cout = HashMultiset.create();
        Set<CompetencyRequestAggregate> set = new HashSet<CompetencyRequestAggregate>();
        for (CompetencyRequest competencyRequest : requests) {
            cout.add(competencyRequest.getCompetencyId());
        }
        for (CompetencyRequest competencyRequest : requests) {
            CompetencyRequestAggregate a = new CompetencyRequestAggregate
                    .Builder()
                    .competencyName(competencyRequest.getCompetencyName())
                    .id(competencyRequest.getCompetencyId())
                    .status(competencyRequest.getStatus())
                    .count(cout.count(competencyRequest.getCompetencyId()))
                    .build();
            set.add(a);
        }
        return set;
    }

    @Override
    public Set<String> getRequestorsIds(String id) {
        Set<String> requestorIds = new HashSet<>();
        Set<CompetencyRequest> requests = competencyRequestService
                .findAll()
                .parallelStream()
                .filter(req -> req.getStatus().equalsIgnoreCase(CompetencyRequestStatus.APPROVED.name()))
                .collect(Collectors.toSet());
        for (CompetencyRequest competencyRequest : requests) {
            requestorIds.add(competencyRequest.getRequestorId());
        }
        return requestorIds;
    }
}

