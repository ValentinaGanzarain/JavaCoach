package com.ada.java_coach.controller;
import com.ada.java_coach.model.dto.CuestionarioDTO;
import com.ada.java_coach.model.entity.Pregunta;
import com.ada.java_coach.service.CuestionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cuestionario")
public class CuestionarioController {

    @Autowired
    CuestionarioService cuestionarioService;

    @GetMapping("pregunta{id_pregunta}")
    public ResponseEntity<Optional<Pregunta>> obtenerPreguntaPorId(@PathVariable Long id_pregunta){
        Optional<Pregunta> pregunta = cuestionarioService.obtenerPreguntaPorId(id_pregunta);
        return ResponseEntity.ok().body(pregunta);
    }

    @PostMapping("pregunta{id_pregunta}/respuesta{id_respuesta}")
    public ResponseEntity<Boolean> validarRespuesta(@PathVariable @Valid Long  id_respuesta){
        Boolean b = cuestionarioService.validarRespuesta(id_respuesta);
        return ResponseEntity.status(HttpStatus.OK).body(b);

    }

    @GetMapping("")
    public ResponseEntity<List<CuestionarioDTO>> obtenerCuestionario() {
         List<CuestionarioDTO> cuestionarioDTO = cuestionarioService.obtenerCuestionario();
        return ResponseEntity.ok().body(cuestionarioDTO);
    }

}
