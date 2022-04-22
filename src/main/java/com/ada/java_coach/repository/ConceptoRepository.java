package com.ada.java_coach.repository;
import com.ada.java_coach.model.entity.Concepto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptoRepository extends JpaRepository <Concepto,Long> {
}