//package hashwork.repository.ui.address.Impl;
//import hashwork.domain.ui.address.StreetName;
//import hashwork.repository.ui.address.StreetNameRepository;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
///**
// * Created by garran on 2015/08/30.
// */
//public class StreetNameRepositoryImpl implements StreetNameRepository {
//    Map<String, Number> lists = new HashMap<>();
//
//    @Override
//    public StreetName findById(String s) {
//        return lists.get(s);
//    }
//
//    @Override
//    public StreetName save(StreetName entity) {
//        return lists.put(entity.getId(), entity);
//    }
//
//    @Override
//    public StreetName update(StreetName entity) {
//        return lists.put(entity.getId(), entity);
//    }
//
//    @Override
//    public void delete(StreetName entity) {
//        lists.remove(entity.getId());
//    }
//
//    @Override
//    public Set<StreetName> findAll() {
//        Set<StreetName> set = new HashSet<>();
//        for (Map.Entry<String, StreetName> entry : lists.entrySet()) {
//            set.add(entry.getValue());
//        }
//        return set;
//    }
//}