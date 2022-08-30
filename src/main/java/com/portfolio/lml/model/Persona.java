package com.portfolio.lml.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud requerida")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud requerida")
    private String apellido;
   
    @Size(min = 1, max = 200, message = "no cumple con la longitud requerida")
    private String img;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud requerida")
    private String ocupacion;
    
    @NotNull
    @Size(min = 1, max = 500, message = "no cumple con la longitud requerida")
    private String acercaDe;
    
    @NotNull
    @Size(min = 1, max = 100, message = "no cumple con la longitud requerida")
    private String banner;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud requerida")
    private String email;
    
    @NotNull
    @Size(min = 1, max = 100, message = "no cumple con la longitud requerida")
    private String linkedinUrl;
    
    @NotNull
    @Size(min = 1, max = 100, message = "no cumple con la longitud requerida")
    private String githubUrl;
    
    @NotNull
    @Size(min = 1, max = 100, message = "no cumple con la longitud requerida")
    private String igUrl;
    
    @NotNull
    @Size(min = 1, max = 100, message = "no cumple con la longitud requerida")
    private String twitterUrl;
    
    
}
