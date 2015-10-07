/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashwork.repository.office.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.office.OfficeType;
import hashwork.repository.office.OfficeTypeRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author BONGANI
 */
public class OfficeTypeRepositoryImpl implements OfficeTypeRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, OfficeType> lists = redisson.getMap("OfficeType");

    @Override
    public OfficeType findById(String s) {
        return lists.get(s);
    }

    @Override
    public OfficeType save(OfficeType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public OfficeType update(OfficeType entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(OfficeType entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<OfficeType> findAll() {
        Set<OfficeType> set = new HashSet<>();
        for (Map.Entry<String, OfficeType> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
