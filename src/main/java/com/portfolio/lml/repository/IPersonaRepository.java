
package com.portfolio.lml.repository;

import com.portfolio.lml.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository <Persona, Long>{

  /*  public boolean existsById(int id);*/
    
}
