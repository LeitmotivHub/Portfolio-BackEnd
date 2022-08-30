
package com.portfolio.lml.service;

import com.portfolio.lml.model.Experiencia;
import com.portfolio.lml.repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    IExperienciaRepository iExpRepo;
    
    public List<Experiencia> list() {
        return iExpRepo.findAll();
    }
    
    public Optional<Experiencia> getOne (int id) {
    return iExpRepo.findById(id);
    }
    
    public Optional<Experiencia>getByPuesto(String puesto) {
    return iExpRepo.findByPuesto(puesto);
    }
    
    public void save(Experiencia exp) {
        iExpRepo.save(exp);
    }
    
    public void delete(int id) {
        iExpRepo.deleteById(id);
    }
    
    public boolean existById (int id) {
        return iExpRepo.existsById(id);
    }
    
    public boolean existByPuesto(String puesto) {
        return iExpRepo.existsByPuesto(puesto);
    }
}
