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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 100, message = "no cumple con la longitud requerida")
    private String titulo;
    
    @NotNull
    @Size(min = 1, max = 500, message = "no cumple con la longitud requerida")
    private String descripcion;
    
    @Size( max = 500, message = "no cumple con la longitud requerida")
    private String imgUrl;
    
    @Size( max = 500, message = "no cumple con la longitud requerida")
    private String urlProyecto;
    
    @Size( max = 12, message = "no cumple con la longitud requerida")
    private String fechaDeLanzamiento;

    public Proyecto() {
    }

    public Proyecto(String titulo, String descripcion, String imgUrl, String urlProyecto, String fechaDeLanzamiento) {
        
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
        this.urlProyecto = urlProyecto;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }
    
}
