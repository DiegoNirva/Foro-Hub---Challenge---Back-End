package com.challenge.Foro.hub.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(
        @NotBlank
        @JsonAlias("USERNAME") String login,
        @NotBlank
        @JsonAlias("PASSWORD")String clave) {

}
