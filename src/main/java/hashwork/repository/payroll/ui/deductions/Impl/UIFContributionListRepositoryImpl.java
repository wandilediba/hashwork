package hashwork.repository.payroll.ui.deductions.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.ui.deductions.UIFContributionList;
import hashwork.repository.payroll.ui.deductions.UIFContributionListRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/09.
 */
public class UIFContributionListRepositoryImpl implements UIFContributionListRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, UIFContributionList> lists = redisson.getMap("uifContributionList");

    public UIFContributionListRepositoryImpl() {

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
