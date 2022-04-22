package com.ada.java_coach.controller;
import com.ada.java_coach.model.entity.Concepto;
import com.ada.java_coach.model.entity.Pregunta;
import com.ada.java_coach.model.entity.Respuesta;
import com.ada.java_coach.reporte.ReportePdf;
import com.ada.java_coach.service.ConceptoService;
import com.ada.java_coach.service.CuestionarioService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/generar")
public class ReporteController {
    @Autowired
    CuestionarioService cuestionarioService;
    @Autowired
    ConceptoService conceptoService;

    @RequestMapping(value = "/reporte", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> reportePdf() {

        var conceptos = (List<Concepto>) conceptoService.obtenerConceptos();
        var respuestas = (List<Respuesta>) cuestionarioService.obtenerRespuestas();
        var preguntas = (List<Pregunta>) cuestionarioService.obtenerPreguntas();

        ByteArrayInputStream bis = ReportePdf.reportePdf(preguntas, respuestas, conceptos);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
