package com.portfolio.lml.service;

import com.portfolio.lml.model.Proyecto;
import com.portfolio.lml.repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    
    @Autowired
    IProyectoRepository proRepo;
    
    
    public List<Proyecto> list() {
        return proRepo.findAll();
    }
    
    public Optional<Proyecto> getOne (int id) {
    return proRepo.findById(id);
    }
    
    public Optional<Proyecto>getByTitulo(String titulo) {
    return proRepo.findByTitulo(titulo);
    }
    
    public void save(Proyecto exp) {
        proRepo.save(exp);
    }
    
    public void delete(int id) {
        proRepo.deleteById(id);
    }
    
    public boolean existById (int id) {
        return proRepo.existsById(id);
    }
    
    public boolean existByTitulo(String titulo) {
        return proRepo.existsByTitulo(titulo);
    }
    
}
