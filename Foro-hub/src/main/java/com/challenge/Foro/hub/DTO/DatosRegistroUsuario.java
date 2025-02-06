package com.challenge.Foro.hub.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank
        @JsonProperty("login") String login,

        @NotBlank
        @JsonProperty("clave") String clave,

        @NotBlank
        @JsonProperty("email") String email) {

}
