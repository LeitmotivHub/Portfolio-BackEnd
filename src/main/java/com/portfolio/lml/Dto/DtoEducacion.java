package com.portfolio.lml.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {

    @NotBlank
    private String carrera;
    @NotBlank
    private String institucion;
    
    private String logoUrl;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaEgreso;

    public DtoEducacion() {
    }

    public DtoEducacion(String carrera, String institucion, String logoUrl, String fechaInicio, String fechaEgreso) {
        this.carrera = carrera;
        this.institucion = institucion;
        this.logoUrl = logoUrl;
        this.fechaInicio = fechaInicio;
        this.fechaEgreso = fechaEgreso;
    }

    

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(String fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

}
