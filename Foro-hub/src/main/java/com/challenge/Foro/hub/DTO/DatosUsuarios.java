package com.challenge.Foro.hub.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosUsuarios(
        @NotBlank
        @JsonAlias("USERNAME") String login,
        @NotBlank
        @JsonAlias("PASSWORD")String clave) {

}
