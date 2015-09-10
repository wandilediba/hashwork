package hashwork.repository.payroll.ui.deductions.Impl;

import hashwork.domain.payroll.ui.deductions.UIFContributionList;
import hashwork.repository.payroll.ui.deductions.UIFContributionListRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/09.
 */
public class UIFContributionListImpl implements UIFContributionListRepository {
    Map<String, UIFContributionList> lists = new HashMap<>();

    public UIFContributionListImpl() {

    }

    @Override
    public UIFContributionList findById(String s) {
        return lists.get(s);
    }

    @Override
    public UIFContributionList save(UIFContributionList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public UIFContributionList update(UIFContributionList entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(UIFContributionList entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<UIFContributionList> findAll() {
        Set<UIFContributionList> set = new HashSet<>();
        for (Map.Entry<String, UIFContributionList> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
