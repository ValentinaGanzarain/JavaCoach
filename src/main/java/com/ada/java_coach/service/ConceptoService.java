package com.ada.java_coach.service;
import com.ada.java_coach.model.entity.Concepto;
import java.util.List;
import java.util.Optional;


public interface ConceptoService {

    List<Concepto> obtenerConceptos();

    Concepto crearConcepto(Concepto concepto);

    Optional<Concepto> obtenerPorId (Long id_concepto);

    Boolean eliminarConcepto(Long id_concepto) ;

    Concepto actualizarConcepto(Concepto concepto);



}


