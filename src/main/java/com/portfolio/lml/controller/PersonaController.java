
package com.portfolio.lml.controller;

import com.portfolio.lml.interfaceService.IPersonaService;
import com.portfolio.lml.model.Persona;
import com.portfolio.lml.security.controller.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService iPersoServ;
    
    @GetMapping ("/personas/traer")
    public List<Persona> getPersona() {
        return iPersoServ.getPersona();
    }
    
    
    @PostAuthorize("hasRole ('ADMIN')")
    @PostMapping ("/personas/crear")
    public String createPersona (@RequestBody Persona personaACrear) {
        iPersoServ.savePersona(personaACrear);
        return "Creado correctamente";
    }
    
    
    @PostAuthorize("hasRole ('ADMIN')")
    @DeleteMapping ("/personas/borrar/{id}")
    public String deletePersona (@PathVariable long id) {
    iPersoServ.deletePersona(id);
    return "Se elimino correctamente";
    }
    

    
    

    
    
/*
    @PostAuthorize("hasRole ('ADMIN')")
    //URL:PUERTO/personas/editar/id?nombre & apellido & img
    @PutMapping ("/personas/editar/{id}")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevaImg,
                                @RequestParam("ocupacion") String nuevaOcupacion,
                                @RequestParam("acercaDe") String nuevaAcercaDe,
                                @RequestParam("banner") String nuevoBanner,
                                @RequestParam("email") String nuevoEmail,
                                @RequestParam("linkedinUrl") String nuevoLinkedinUrl,
                                @RequestParam("githubUrl") String nuevoGithubUrl,
                                @RequestParam("igUrl") String nuevoIgUrl,
                                @RequestParam("twitterUrl") String nuevoTwitterUrl)
                                                                        {
        
        
        Persona personaAEditar = iPersoServ.findPersona(id);
        personaAEditar.setNombre(nuevoNombre);
        personaAEditar.setApellido(nuevoApellido);
        personaAEditar.setImg(nuevaImg);
        personaAEditar.setOcupacion(nuevaOcupacion);
        personaAEditar.setAcercaDe(nuevaAcercaDe);
        personaAEditar.setBanner(nuevoBanner);
        personaAEditar.setEmail(nuevoEmail);
        personaAEditar.setLinkedinUrl(nuevoLinkedinUrl);
        personaAEditar.setGithubUrl(nuevoGithubUrl);
        personaAEditar.setIgUrl(nuevoIgUrl);
        personaAEditar.setTwitterUrl(nuevoTwitterUrl);
        
        iPersoServ.savePersona(personaAEditar);
        
        
        return personaAEditar;  //Dudas con este return
    }
    
    */
    
    
    
    
    @PutMapping("/personas/editar/{id}")
    public /* ResponseEntity<?> */ Persona editPersona(@PathVariable("id") int id, @RequestBody Persona pers){
    /*    //Validamos si existe el ID
        if(!iPersoServ.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST); */
        
        
        Persona personaAEditar = iPersoServ.findPersona(pers.getId());
        personaAEditar.setNombre(pers.getNombre());
        personaAEditar.setApellido(pers.getApellido());
        personaAEditar.setImg(pers.getImg());
        personaAEditar.setOcupacion(pers.getOcupacion());
        personaAEditar.setAcercaDe(pers.getAcercaDe());
        personaAEditar.setBanner(pers.getBanner());
        personaAEditar.setEmail(pers.getEmail());
        personaAEditar.setLinkedinUrl(pers.getLinkedinUrl());
        personaAEditar.setGithubUrl(pers.getGithubUrl());
        personaAEditar.setIgUrl(pers.getIgUrl());
        personaAEditar.setTwitterUrl(pers.getTwitterUrl());
        
        iPersoServ.savePersona(personaAEditar);
        return personaAEditar; /*new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);*/
             
    }
    
    
    
    
    
    
    
    
    
    
    /*@GetMapping ("/personas/traer/perfil/{id}")
    public Persona findPersona(@PathVariable Long id) {
        
        
       return  iPersoServ.findPersona(id);
       
            
            
    }
*/
    
     @GetMapping ("/personas/traer/perfil")
    public Persona findPersona() {
        
        
       return  iPersoServ.findPersona((long)1);
       
            
            
    }

}
