package hashwork.services.payroll.ui.deductions.Impl;

import hashwork.domain.payroll.ui.deductions.AllowanceTypeList;
import hashwork.repository.payroll.ui.deductions.AllowanceTypeListRepository;
import hashwork.repository.payroll.ui.deductions.Impl.AllowanceTypeListRepositoryImpl;
import hashwork.services.payroll.ui.deductions.AllowanceTypeListService;

import java.util.Set;

/**
 * Created by zamzam on 15/09/08.
 */
public class AllowanceTypeListServiceImpl implements AllowanceTypeListService {
    private final AllowanceTypeListRepository repo = new AllowanceTypeListRepositoryImpl();

    @Override
    public AllowanceTypeList findById(String s) {
        return repo.findById(s);
    }

    @Override
    public AllowanceTypeList save(AllowanceTypeList entity) {
        return repo.save(entity);
    }

    @Override
    public AllowanceTypeList update(AllowanceTypeList entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(AllowanceTypeList entity) {
        repo.delete(entity);
    }

    @Override
    public Set<AllowanceTypeList> findAll() {
        return repo.findAll();
    }
}
