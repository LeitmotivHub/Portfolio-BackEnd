package com.portfolio.lml.service;

import com.portfolio.lml.model.Educacion;
import com.portfolio.lml.repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {

    @Autowired
    IEducacionRepository eduRepo;

    public List<Educacion> list() {
        return eduRepo.findAll();
    }

    public Optional<Educacion> getOne(int id) {
        return eduRepo.findById(id);
    }

    public Optional<Educacion> getByCarrera(String carrera) {
        return eduRepo.findByCarrera(carrera);
    }

    public void save(Educacion educacion) {
        eduRepo.save(educacion);
    }

    public void delete(int id) {
        eduRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return eduRepo.existsById(id);
    }

    public boolean existsByCarrera(String carrera) {
        return eduRepo.existsByCarrera(carrera);
    }
}
