package com.ada.java_coach.repository;
import com.ada.java_coach.model.entity.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

}
