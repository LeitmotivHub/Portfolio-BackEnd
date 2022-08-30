
package com.portfolio.lml.repository;

import com.portfolio.lml.model.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer>{
    public Optional <Proyecto> findByTitulo(String titulo);
    public boolean existsByTitulo (String titulo);
    
}
