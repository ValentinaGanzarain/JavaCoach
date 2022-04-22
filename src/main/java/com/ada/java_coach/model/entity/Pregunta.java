package com.ada.java_coach.model.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity @NoArgsConstructor @AllArgsConstructor
@Table(name = "DB_PREGUNTAS")
public class Pregunta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pregunta;
    private String contenido_pregunta;
    private int id_concepto;



}
