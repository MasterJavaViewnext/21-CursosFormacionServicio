package com.curso.cursos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.cursos.dao.CursoDao;
import com.curso.cursos.model.Curso;

import jakarta.transaction.Transactional;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	CursoDao dao;
	
	@Override
	public List<Curso> findAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Curso> findById(Integer codigo) {
		return dao.findById(codigo);
	}

	@Override
	public Optional<Curso> findByNombre(String nombre) {
		return dao.findByNombre(nombre);
	}

	@Override
	public List<Curso> insert(Curso curso) {
		dao.save(curso);
		return dao.findAll();
	}

	@Override
	public void update(Curso curso) {
		dao.save(curso);
	}

	@Override
	public void delete(Integer codigo) {
		dao.deleteById(codigo);
	}

	/**
	 * Funcion que obtiene primero el curso a partir de su codigo y actualiza su 
	 * duracion si es diferente
	 */
	@Override
	@Transactional
	public void updateDuracion(Integer codigo, Integer duracion) {
		findById(codigo).ifPresent( c -> c.setDuracion(duracion) );
	}
	
	/**
	 * Funcion que devuelve todos los cursos entre 2 precios incluidos
	 */
	public List<Curso> findByPrecioBetween(Integer min, Integer max){
		return dao.findByPrecioBetween(min, max);
	}

}
