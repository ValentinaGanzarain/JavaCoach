package com.ada.java_coach.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.AssertFalse;


@AssertFalse
@Data @AllArgsConstructor @NoArgsConstructor

public class CuestionarioDTO {

    private Long id_pregunta;
    private Long id_respuesta;
    private String contenido_respuestas;
    @AssertFalse
    private Boolean es_correcta;

}