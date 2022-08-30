
package com.portfolio.lml.Dto;

import javax.validation.constraints.NotBlank;


public class DtoProyecto {
    @NotBlank
    private String titulo;
    @NotBlank 
    private String descripcion;
    private String imgUrl;
    private String urlProyecto;
    private String fechaDeLanzamiento;

    public DtoProyecto() {
    }

    public DtoProyecto(String titulo, String descripcion, String imgUrl, String urlProyecto, String fechaDeLanzamiento) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
        this.urlProyecto = urlProyecto;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUrlProyecto() {
        return urlProyecto;
    }

    public void setUrlProyecto(String urlProyecto) {
        this.urlProyecto = urlProyecto;
    }

    public String getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(String fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }
    
    
    
    
}
