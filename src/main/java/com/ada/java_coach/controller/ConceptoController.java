package com.ada.java_coach.controller;
import com.ada.java_coach.model.entity.Concepto;
import com.ada.java_coach.service.ConceptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/conceptos")
public class ConceptoController {

    @Autowired
    ConceptoService conceptoService;


    @GetMapping("")
    public ResponseEntity<List<Concepto>> obtenerConceptos() {
        List<Concepto> conceptos = conceptoService.obtenerConceptos();
        return ResponseEntity.status(HttpStatus.OK).body(conceptos);
    }


    @GetMapping("/{id_concepto}")
    public ResponseEntity<Optional<Concepto>> obtenerPorId(@PathVariable Long id_concepto) {
        Optional<Concepto> conceptosId = conceptoService.obtenerPorId(id_concepto);
        return ResponseEntity.status(HttpStatus.OK).body(conceptosId);
    }


    @PostMapping("/crear")
    public ResponseEntity<Concepto> crearConcepto(@RequestBody @Valid Concepto concepto) {
        Concepto conceptoNuevo = conceptoService.crearConcepto(concepto);
        return ResponseEntity.status(HttpStatus.CREATED).body(conceptoNuevo);
    }


    @PutMapping("/actualizar")
    public ResponseEntity<Concepto> actualizarConcepto(@RequestBody Concepto concepto) {
     Concepto conceptoA = conceptoService.actualizarConcepto(concepto);
     return ResponseEntity.status(HttpStatus.OK).body(conceptoA);
    }


    @DeleteMapping( "/eliminar{id_concepto}")
    public String eliminarConcepto(@PathVariable Long id_concepto) {
        Boolean b = conceptoService.eliminarConcepto(id_concepto);
        if (b){
            return "El concepto con id " + id_concepto + " fue eliminado";
        }else{
            return "El concepto con id " + id_concepto + " no existe";
        }
    }

}







