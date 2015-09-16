package hashwork.services.ui.demographics.Impl;

import hashwork.domain.ui.demographics.LanguageProficiency;
import hashwork.repository.ui.demographics.Impl.LanguageProficiencyRepositoryImpl;
import hashwork.repository.ui.demographics.LanguageProficiencyRepository;
import hashwork.services.ui.demographics.LanguageProficiencyService;

import java.util.Set;

/**
 * Created by hashcode on 2015/08/18.
 */
public class LanguageProficiencyServiceImpl implements LanguageProficiencyService {
    private final LanguageProficiencyRepository repo = new LanguageProficiencyRepositoryImpl();
    @Override
    public LanguageProficiency findById(String s) {
        return repo.findById(s);
    }

    @Override
    public LanguageProficiency save(LanguageProficiency entity) {
        return repo.save(entity);
    }

    @Override
    public LanguageProficiency update(LanguageProficiency entity) {
        return repo.update(entity);
    }

    @Override
    public void delete(LanguageProficiency entity) {
        repo.delete(entity);
    }

    @Override
    public Set<LanguageProficiency> findAll() {
        return repo.findAll();
    }
}
