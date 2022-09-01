
package com.portfolio.lml.controller;

import com.portfolio.lml.Dto.DtoEducacion;
import com.portfolio.lml.model.Educacion;
import com.portfolio.lml.security.controller.Mensaje;
import com.portfolio.lml.service.EducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins =    "https://portfolioleandrolopez.web.app")  //"http://localhost:4200")
public class EducacionController {
    @Autowired
    EducacionService eduServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = eduServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
        if(!eduServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = eduServ.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!eduServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        eduServ.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getCarrera())){
            return new ResponseEntity(new Mensaje("Este campo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(eduServ.existsByCarrera(dtoEdu.getCarrera())){
            return new ResponseEntity(new Mensaje("Esta carrera ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        //falta validar la descripcion al igual que con el nombre
        
        Educacion educacion = new Educacion(
                dtoEdu.getCarrera(), dtoEdu.getInstitucion(), dtoEdu.getLogoUrl(), dtoEdu.getFechaInicio(), dtoEdu.getFechaEgreso()
            );
        eduServ.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEdu){
        if(!eduServ.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(eduServ.existsByCarrera(dtoEdu.getCarrera()) && eduServ.getByCarrera(dtoEdu.getCarrera()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esta carrera ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEdu.getCarrera())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        //falta validar la descripcion al igual que se hizo con el nombre
        
        
        Educacion educacion = eduServ.getOne(id).get();
        
        educacion.setCarrera(dtoEdu.getCarrera());
        educacion.setInstitucion(dtoEdu.getInstitucion());
        educacion.setLogoUrl(dtoEdu.getLogoUrl());
        educacion.setFechaInicio(dtoEdu.getFechaInicio());
        educacion.setFechaEgreso(dtoEdu.getFechaEgreso());
        
        eduServ.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
