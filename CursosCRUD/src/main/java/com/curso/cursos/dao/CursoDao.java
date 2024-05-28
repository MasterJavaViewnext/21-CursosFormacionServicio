package com.curso.cursos.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.cursos.model.Curso;

public interface CursoDao extends JpaRepository<Curso, Integer> {

	Curso findByPrecio(Double precio);

	//@Query("SELECT c FROM Curso c WHERE c.precio BETWEEN ?1 AND ?2")
	//List<Curso> findBetweenPrecio(Integer min, Integer max);
	List<Curso> findByPrecioBetween(Integer min, Integer max);
	Optional<Curso> findByNombre(String nombre);
}
