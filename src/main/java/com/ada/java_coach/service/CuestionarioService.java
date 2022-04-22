package com.ada.java_coach.service;
import com.ada.java_coach.model.dto.CuestionarioDTO;
import com.ada.java_coach.model.entity.Pregunta;
import com.ada.java_coach.model.entity.Respuesta;
import java.util.List;
import java.util.Optional;

public interface CuestionarioService {

    Boolean validarRespuesta (Long id_respuesta);

    List<CuestionarioDTO> obtenerCuestionario();

    Optional<Respuesta>obtenerRespuestaPorId(Long id_respuesta);

    List<Pregunta> obtenerPreguntas ();


    List<Respuesta> obtenerRespuestas ();


    Optional<Pregunta> obtenerPreguntaPorId(Long id_pregunta);



}
