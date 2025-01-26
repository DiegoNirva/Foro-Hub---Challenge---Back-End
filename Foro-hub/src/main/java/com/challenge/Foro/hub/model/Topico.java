package com.challenge.Foro.hub.model;

import com.challenge.Foro.hub.DTO.DatosActualizarTopico;
import com.challenge.Foro.hub.DTO.DatosTopico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Data
@Entity
@Table(name = "topico")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String titulo;
    @NotNull
    private String mensaje;
    @NotNull
    private String fechaDeCreacion;
    int status;
    @NotNull
    private Usuario autor;
    @NotNull
    private String curso;

    Set<Respuesta> respuestas;

    public Topico(DatosTopico datosTopico){
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fechaDeCreacion = fechaFormateada();
        this.status = 1; //se utilizamos 1 para true y 0 para false
        this.autor = datosTopico.autor();
        this.curso = datosTopico.curso();

    }
    public Topico actualizarTopicos(DatosActualizarTopico datosActualizarTopico){

        if(datosActualizarTopico.titulo() !=null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.mensaje() !=null){
            this.mensaje = datosActualizarTopico.mensaje();
        }

        if(datosActualizarTopico.autor() !=null){
            this.autor = datosActualizarTopico.autor();
        }
        if(datosActualizarTopico.curso() !=null){
            this.curso = datosActualizarTopico.curso();

        }
        return this;
    }

    //metodo para formatear fecha
    private String fechaFormateada(){
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaFormateada = fechaActual.format(formato);
        return  fechaFormateada;
    }


}
