package com.ada.java_coach.model.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import java.io.Serializable;


@Data @NoArgsConstructor @AllArgsConstructor
@Entity @AssertFalse
@Table(name = "DB_RESPUESTAS")
public class Respuesta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_respuesta;
    private String contenido_respuestas;
    private int id_pregunta;
    @AssertTrue (message = "La respuesta es correcta")
    private Boolean es_correcta;






}
