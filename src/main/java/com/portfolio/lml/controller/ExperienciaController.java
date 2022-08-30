package com.portfolio.lml.controller;

import com.portfolio.lml.Dto.DtoExperiencia;
import com.portfolio.lml.model.Experiencia;
import com.portfolio.lml.security.controller.Mensaje;
import com.portfolio.lml.service.ExperienciaService;
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
@RequestMapping ("/explab")
@CrossOrigin (origins = "http://localhost:4200")
public class ExperienciaController {
    @Autowired
    ExperienciaService expServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = expServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!expServ.existById(id))
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = expServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!expServ.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.NOT_FOUND);
        }
        expServ.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp){      
        if(StringUtils.isBlank(dtoExp.getPuesto()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(expServ.existByPuesto(dtoExp.getPuesto()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoExp.getPuesto(), dtoExp.getEmpresa(), dtoExp.getLogo(), dtoExp.getActividades(),
                                                  dtoExp.getInicio(), dtoExp.getEgreso(), dtoExp.getUrlEmpresa());
        expServ.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExp){
        //Validamos si existe el ID
        if(!expServ.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(expServ.existByPuesto(dtoExp.getPuesto()) && expServ.getByPuesto(dtoExp.getPuesto()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoExp.getPuesto()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = expServ.getOne(id).get();
        experiencia.setPuesto(dtoExp.getPuesto());
        experiencia.setEmpresa((dtoExp.getEmpresa()));
        experiencia.setLogo(dtoExp.getLogo());
        experiencia.setActividades(dtoExp.getActividades());
        experiencia.setInicio(dtoExp.getInicio());
        experiencia.setEgreso(dtoExp.getEgreso());
        experiencia.setUrlEmpresa(dtoExp.getUrlEmpresa());
        
        expServ.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
    
    
    
    
}
