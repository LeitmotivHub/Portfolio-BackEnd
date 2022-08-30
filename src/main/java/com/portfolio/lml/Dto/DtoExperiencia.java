
package com.portfolio.lml.Dto;

import javax.validation.constraints.NotBlank;


public class DtoExperiencia {
    
    @NotBlank
    private String puesto;
    @NotBlank
    private String empresa;
    @NotBlank
    private String logo;
    @NotBlank
    private String actividades;
    @NotBlank
    private String inicio;
    @NotBlank
    private String egreso;
    
    private String urlEmpresa;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String puesto, String empresa, String logo, String actividades, String inicio, String egreso, String urlEmpresa) {
        this.puesto = puesto;
        this.empresa = empresa;
        this.logo = logo;
        this.actividades = actividades;
        this.inicio = inicio;
        this.egreso = egreso;
        this.urlEmpresa = urlEmpresa;
        
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getEgreso() {
        return egreso;
    }

    public void setEgreso(String egreso) {
        this.egreso = egreso;
    }

    public String getUrlEmpresa() {
        return urlEmpresa;
    }

    public void setUrlEmpresa(String urlEmpresa) {
        this.urlEmpresa = urlEmpresa;
    }
    
    
    
    
    
}
