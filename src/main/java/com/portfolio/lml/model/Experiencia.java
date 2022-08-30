
package com.portfolio.lml.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String puesto;
    private String empresa;
    private String logo;
    private String actividades;
    private String inicio;
    private String egreso;
    private String urlEmpresa;

    public Experiencia() {
    }

    public Experiencia(String puesto, String empresa, String logo, String actividades, String inicio, String egreso, String urlEmpresa) {
        this.puesto = puesto;
        this.empresa = empresa;
        this.logo = logo;
        this.actividades = actividades;
        this.inicio = inicio;
        this.egreso = egreso;
        this.urlEmpresa = urlEmpresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
