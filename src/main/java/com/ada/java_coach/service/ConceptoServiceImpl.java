package com.ada.java_coach.service;
import com.ada.java_coach.excepciones.BadRequestException;
import com.ada.java_coach.excepciones.NotFoundException;
import com.ada.java_coach.model.entity.Concepto;
import com.ada.java_coach.repository.ConceptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ConceptoServiceImpl implements ConceptoService {

    @Autowired
    ConceptoRepository conceptoRepository;


    @Override
    public List<Concepto> obtenerConceptos() {
        return conceptoRepository.findAll();
    }

    @Override
    public Optional<Concepto> obtenerPorId(Long id_concepto){
        if (!conceptoRepository.existsById(id_concepto)) {
            throw new NotFoundException("El concepto " + id_concepto + " no existe");
        }

        return conceptoRepository.findById(id_concepto);
    }


    @Override
    public Concepto crearConcepto(Concepto concepto) {
        if (concepto.getContenido_concepto() == null || concepto.getContenido_concepto().isEmpty()) {
            throw new BadRequestException("");
        }
            return conceptoRepository.save(concepto);
    }

    @Override
    public Concepto actualizarConcepto(Concepto concepto){
        return conceptoRepository.save(concepto);
    }

    @Override
    public Boolean eliminarConcepto(Long id_concepto)  {
       try{ conceptoRepository.deleteById(id_concepto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
