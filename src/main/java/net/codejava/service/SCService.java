package net.codejava.service;

import java.util.List;

import net.codejava.entity.ServiceCenter;
import net.codejava.repository.SCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SCService {
    @Autowired
    private SCRepository repo;

    public List<ServiceCenter> listAll() {
        return repo.findAll();
    }

    public void save(ServiceCenter serviceCenter) {
        repo.save(serviceCenter);
    }

    public ServiceCenter get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
