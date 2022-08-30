package com.portfolio.lml.controller;

import com.portfolio.lml.Dto.DtoProyecto;
import com.portfolio.lml.model.Proyecto;
import com.portfolio.lml.security.controller.Mensaje;
import com.portfolio.lml.service.ProyectoService;
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
@RequestMapping ("/proyectos")
@CrossOrigin (origins = "http://localhost:4200")
public class ProyectoController {
    
    
    @Autowired
    ProyectoService proServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = proServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!proServ.existById(id))
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = proServ.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proServ.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.NOT_FOUND);
        }
        proServ.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoPro){      
        if(StringUtils.isBlank(dtoPro.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(proServ.existByTitulo(dtoPro.getTitulo()))
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = new Proyecto(dtoPro.getTitulo(), dtoPro.getDescripcion(), dtoPro.getImgUrl(), dtoPro.getUrlProyecto(), dtoPro.getFechaDeLanzamiento());
        proServ.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoPro){
        //Validamos si existe el ID
        if(!proServ.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara titulo de proyecto
        if(proServ.existByTitulo(dtoPro.getTitulo()) && proServ.getByTitulo(dtoPro.getTitulo()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoPro.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyectoModificado = proServ.getOne(id).get();
        proyectoModificado.setTitulo(dtoPro.getTitulo());
        proyectoModificado.setDescripcion((dtoPro.getDescripcion()));
        proyectoModificado.setImgUrl(dtoPro.getImgUrl());
        proyectoModificado.setUrlProyecto(dtoPro.getUrlProyecto());
        proyectoModificado.setFechaDeLanzamiento(dtoPro.getFechaDeLanzamiento());
        
        
        proServ.save(proyectoModificado);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
             
    }
    
    
    
    
    
}
