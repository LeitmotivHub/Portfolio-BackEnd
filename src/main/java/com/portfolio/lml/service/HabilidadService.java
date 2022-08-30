
package com.portfolio.lml.service;

import com.portfolio.lml.model.Habilidad;
import com.portfolio.lml.repository.IHabilidadRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabilidadService {
    
    @Autowired
    IHabilidadRepository habilidadRepo;
    
    
    public List<Habilidad> list() {
        return habilidadRepo.findAll();
    }
    
    public Optional<Habilidad> getOne (int id) {
    return habilidadRepo.findById(id);
    }
    
    public Optional<Habilidad>getByNombreHabilidad(String nHabilidad) {
    return habilidadRepo.findByNombreHabilidad(nHabilidad);
    }
    
    public void save(Habilidad exp) {
        habilidadRepo.save(exp);
    }
    
    public void delete(int id) {
        habilidadRepo.deleteById(id);
    }
    
    public boolean existById (int id) {
        return habilidadRepo.existsById(id);
    }
    
    public boolean existByNombreHabilidad(String nHabilidad) {
        return habilidadRepo.existsByNombreHabilidad(nHabilidad);
    }
    
}
