package com.challenge.Foro.hub.model;

import com.challenge.Foro.hub.DTO.DatosTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "topico")
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String titulo;
    String mensaje;
    String fechaDeCreacion;
    int status;
    String autor;
    String curso;

    public Topico(DatosTopico datosTopico){
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fechaDeCreacion = fechaFormateada();
        this.status = 1; //se utilizaran 1 para true y 0 para false
        this.autor = datosTopico.autor();
        this.curso = datosTopico.autor();

    }

    //metodo para formatear fecha
    private String fechaFormateada(){
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaFormateada = fechaActual.format(formato);
        return  fechaFormateada;
    }



}
