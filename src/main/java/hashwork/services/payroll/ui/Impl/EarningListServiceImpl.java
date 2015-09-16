package hashwork.services.payroll.ui.Impl;

import hashwork.domain.payroll.ui.EarningsList;
import hashwork.repository.payroll.ui.EarningListRepository;
import hashwork.repository.payroll.ui.Impl.EarningListRepositoryImpl;
import hashwork.services.payroll.ui.EarningListService;

import java.util.Set;

/**
 * Created by zamzam on 15/09/08.
 */
public class EarningListServiceImpl implements EarningListService {
    private final EarningListRepository repo = new EarningListRepositoryImpl();

    @Override
    public EarningsList findById(String s) {
        return repo.findById(s);
    }

    @Override
    public EarningsList save(EarningsList entity) {
        return repo.save(entity);
    }

    @Override
    public EarningsList update(EarningsList entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(EarningsList entity) {
        repo.delete(entity);
    }

    @Override
    public Set<EarningsList> findAll() {
        return repo.findAll();
    }
}
