
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
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud requerida")
    private String nombreHabilidad;
    
    @Size(max = 500, message = "no cumple con la longitud requerida")
    private String logoUrl;
    
    @NotNull
    @Size(min = 1, max = 3, message = "no cumple con la longitud requerida")
    private String porcentajeDeDominio;

    
    public Habilidad() {
        
    }

    public Habilidad(String nombreHabilidad, String logo, String porcentajeDeDominio) {
        this.nombreHabilidad = nombreHabilidad;
        this.logoUrl = logo;
        this.porcentajeDeDominio = porcentajeDeDominio;
    }
    
    
    
}
