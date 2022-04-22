package com.ada.java_coach.service;
import com.ada.java_coach.excepciones.NotFoundException;
import com.ada.java_coach.model.dto.CuestionarioDTO;
import com.ada.java_coach.model.entity.Pregunta;
import com.ada.java_coach.model.entity.Respuesta;
import com.ada.java_coach.repository.PreguntaRespository;
import com.ada.java_coach.repository.RespuestaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CuestionarioServiceImpl implements CuestionarioService {

    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    PreguntaRespository preguntaRespository;


    ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<CuestionarioDTO> obtenerCuestionario() {
        List<Respuesta> respuestas = respuestaRepository.findAll();
        List<CuestionarioDTO> cList = new ArrayList<>();
        for(Respuesta respuesta: respuestas) {
            CuestionarioDTO cuestionario = modelMapper.map(respuesta, CuestionarioDTO.class);
                cuestionario.setId_respuesta(respuesta.getId_respuesta());
                cuestionario.setContenido_respuestas(respuesta.getContenido_respuestas());
                cuestionario.setEs_correcta(respuesta.getEs_correcta());
                cuestionario.setId_pregunta(cuestionario.getId_pregunta());
                cList.add(cuestionario);
        }

        return cList;
    }

    @Override
    public List<Pregunta> obtenerPreguntas(){
       return preguntaRespository.findAll();
    }

    @Override
    public List<Respuesta> obtenerRespuestas(){
        return respuestaRepository.findAll();
    }

    @Override
    public Optional<Respuesta> obtenerRespuestaPorId(Long id_respuesta) {
        if (!respuestaRepository.existsById(id_respuesta)) {
            throw new NotFoundException("La respuesta " + id_respuesta + " no existe");
        }
        return respuestaRepository.findById(id_respuesta);
    }

    @Override
    public Optional<Pregunta> obtenerPreguntaPorId(Long id_pregunta) {
        if (!preguntaRespository.existsById(id_pregunta)) {
            throw new NotFoundException("La pregunta " + id_pregunta + " no existe");
        }
        return preguntaRespository.findById(id_pregunta);
    }

    public Boolean validarRespuesta(Long id_respuesta){
        Optional<Respuesta> respuesta = respuestaRepository.findById(id_respuesta);
        Boolean correcta = respuesta.get().getEs_correcta();
        return correcta;

    }

}



