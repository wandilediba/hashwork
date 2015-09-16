/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.services.office.Impl;

import hashwork.domain.office.OfficeType;
import hashwork.repository.office.Impl.OfficeTypeRepositoryImpl;
import hashwork.repository.office.OfficeTypeRepository;
import hashwork.services.office.OfficeTypeService;

import java.util.Set;

/**
 * @author BONGANI
 */
public class OfficeTypeServiceImpl implements OfficeTypeService {

    private final OfficeTypeRepository repo = new OfficeTypeRepositoryImpl();

    @Override
    public OfficeType findById(String id) {
        return repo.findById(id);
    }

    @Override
    public OfficeType save(OfficeType entity) {
        return repo.save(entity);
    }

    @Override
    public OfficeType update(OfficeType entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(OfficeType entity) {
        repo.delete(entity);
    }

    @Override
    public Set<OfficeType> findAll() {
        return repo.findAll();
    }
}
