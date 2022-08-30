
package com.portfolio.lml.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoHabilidad {
    
    @NotBlank
    private String nombreHabilidad;
    
    private String logoUrl;
    
    @NotBlank
    private String porcentajeDeDominio;

    public DtoHabilidad() {
    }

    public DtoHabilidad(String nombreHabilidad, String logoUrl, String porcentajeDeDominio) {
        this.nombreHabilidad = nombreHabilidad;
        this.logoUrl = logoUrl;
        this.porcentajeDeDominio = porcentajeDeDominio;
    }
    
    
    
    
}
