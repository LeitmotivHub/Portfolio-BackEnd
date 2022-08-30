
package com.portfolio.lml.repository;

import com.portfolio.lml.model.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadRepository extends JpaRepository<Habilidad, Integer> {
    public Optional <Habilidad> findByNombreHabilidad(String nombreHabilidad);
    public boolean existsByNombreHabilidad (String nombreHabilidad);
    
}
