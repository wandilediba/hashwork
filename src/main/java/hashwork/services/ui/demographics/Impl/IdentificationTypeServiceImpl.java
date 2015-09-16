package hashwork.services.ui.demographics.Impl;

import hashwork.domain.ui.demographics.IdentificationType;
import hashwork.repository.ui.demographics.IdentificationTypeRepository;
import hashwork.repository.ui.demographics.Impl.IdentificationTypeRepositoryImpl;
import hashwork.services.ui.demographics.IdentificationTypeService;

import java.util.Set;

/**
 * Created by hashcode on 2015/08/18.
 */
public class IdentificationTypeServiceImpl implements IdentificationTypeService {
    private final IdentificationTypeRepository repo = new IdentificationTypeRepositoryImpl();
    @Override
    public IdentificationType findById(String s) {
        return repo.findById(s);
    }

    @Override
    public IdentificationType save(IdentificationType entity) {
        return repo.save(entity);
    }

    @Override
    public IdentificationType update(IdentificationType entity) {
        return repo.update(entity);
    }

    @Override
    public void delete(IdentificationType entity) {
        repo.delete(entity);

    }

    @Override
    public Set<IdentificationType> findAll() {
        return repo.findAll();
    }
}
