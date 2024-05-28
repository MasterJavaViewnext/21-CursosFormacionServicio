package com.curso.cursos.service;

import java.util.List;
import java.util.Optional;

import com.curso.cursos.model.Curso;

public interface CursoService {
	List<Curso> findAll();
	Optional<Curso> findById(Integer codigo);
	Optional<Curso> findByNombre(String nombre);
	List<Curso> insert(Curso curso);
	void update(Curso curso);
	void delete(Integer codigo);
	void updateDuracion(Integer codigo, Integer duracion);
	List<Curso> findByPrecioBetween(Integer min, Integer max);
	
}
