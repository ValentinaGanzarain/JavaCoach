package com.ada.java_coach.model.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table (name = "DB_CONCEPTOS")
public class Concepto implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id_concepto;
    private String nombre_concepto;
    @NotNull(message = "Debe introducir el contenido del concepto")
    private String contenido_concepto;
    private String unidad;

}

