package com.challenge.Foro.hub.model;

import com.challenge.Foro.hub.DTO.DatosCurso;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "curso")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nombre;

    @NotNull
    private String categoria;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Topico> topico;

    public Curso(DatosCurso datosCurso){
        this.nombre = datosCurso.nombre();
        this.categoria = datosCurso.categoria();
        if( datosCurso.topicos() != null){
            this.topico = datosCurso.topicos().stream().map(datosTopico -> new Topico()).collect(Collectors.toSet());
        }else {
            this.topico = new HashSet<>();
        }
    }



}
