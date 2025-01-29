package com.challenge.Foro.hub.model;

import com.challenge.Foro.hub.DTO.DatosRespuesta;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "respuesta")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String mensaje;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    @NotNull
    private String fechaDeCreacion;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Respuesta(DatosRespuesta datosRespuesta){
        this.mensaje = datosRespuesta.mensaje();

    }

}
