package hashwork.services.payroll.ui.deductions.Impl;

import hashwork.domain.payroll.ui.deductions.UIFContributionList;
import hashwork.repository.payroll.ui.deductions.UIFContributionListRepository;
import hashwork.repository.payroll.ui.deductions.Impl.UIFContributionListRepositoryImpl;
import hashwork.services.payroll.ui.deductions.UIFContributionListService;

import java.util.Set;

/**
 *  Created by kurt on 15/09/13.
 */
public class UIFContributionListServiceImpl implements UIFContributionListService {
    private final UIFContributionListRepositoryImpl repo = new UIFContributionListRepositoryImpl();

    @Override
    public UIFContributionList findById(String s) {
        return repo.findById(s);
    }

    @Override
    public UIFContributionList save(UIFContributionList entity) {
        return repo.save(entity);
    }

    @Override
    public UIFContributionList update(UIFContributionList entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(UIFContributionList entity) {
        repo.delete(entity);
    }

    @Override
    public Set<UIFContributionList> findAll() {
        return repo.findAll();
    }
}
