
package com.portfolio.lml.controller;

import com.portfolio.lml.Dto.DtoHabilidad;
import com.portfolio.lml.model.Habilidad;
import com.portfolio.lml.security.controller.Mensaje;
import com.portfolio.lml.service.HabilidadService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/habilidades")
@CrossOrigin (origins = "http://localhost:4200")
public class HabilidadController {
    
    @Autowired
    HabilidadService habilidadServ;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list(){
        List<Habilidad> list = habilidadServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") int id){
        if(!habilidadServ.existById(id))
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.NOT_FOUND);
        Habilidad habilidad = habilidadServ.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!habilidadServ.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.NOT_FOUND);
        }
        habilidadServ.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHabilidad dtoHab){      
        if(StringUtils.isBlank(dtoHab.getNombreHabilidad()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(habilidadServ.existByNombreHabilidad(dtoHab.getNombreHabilidad()))
            return new ResponseEntity(new Mensaje("Esa habilidad existe"), HttpStatus.BAD_REQUEST);
        
        Habilidad habilidad = new Habilidad(dtoHab.getNombreHabilidad(), dtoHab.getLogoUrl(), dtoHab.getPorcentajeDeDominio());
        habilidadServ.save(habilidad);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHabilidad dtoHab){
        //Validamos si existe el ID
        if(!habilidadServ.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de habilidades
        if(habilidadServ.existByNombreHabilidad(dtoHab.getNombreHabilidad()) && habilidadServ.getByNombreHabilidad(dtoHab.getNombreHabilidad()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoHab.getNombreHabilidad()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Habilidad habilidadAModificar = habilidadServ.getOne(id).get();
        habilidadAModificar.setNombreHabilidad(dtoHab.getNombreHabilidad());
        habilidadAModificar.setLogoUrl((dtoHab.getLogoUrl()));
        habilidadAModificar.setPorcentajeDeDominio((dtoHab.getPorcentajeDeDominio()));
        
        
        
        
        habilidadServ.save(habilidadAModificar);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
             
    }
    
}


