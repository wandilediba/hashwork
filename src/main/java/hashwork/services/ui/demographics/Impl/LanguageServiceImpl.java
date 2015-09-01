package hashwork.services.ui.demographics.Impl;

import hashwork.domain.ui.demographics.Language;
import hashwork.repository.ui.demographics.Impl.LanguageRepositoryImpl;
import hashwork.repository.ui.demographics.LanguageRepository;
import hashwork.services.ui.demographics.LanguageService;

import java.util.Set;

/**
 * Created by hashcode on 2015/08/18.
 */
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository repo = new LanguageRepositoryImpl();
    @Override
    public Language findById(String s) {
        return repo.findById(s);
    }

    @Override
    public Language save(Language entity) {
        return repo.save(entity);
    }

    @Override
    public Language update(Language entity) {
        return repo.update(entity);
    }

    @Override
    public void delete(Language entity) {
        repo.delete(entity);

    }

    @Override
    public Set<Language> findAll() {
        return repo.findAll();
    }
}
