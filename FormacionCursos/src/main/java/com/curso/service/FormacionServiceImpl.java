package com.curso.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.CursoDTO;
import com.curso.model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {

	private static final String URL = "http://localhost:8080/cursos";

	@Autowired
	RestTemplate template;
	
	/**
	 * Método que transforma la lista de curso obtenida de CursosCRUD en objetos Formacion
	 * @return lista de objetos Formacion 
	 */
	@Override
	public List<Formacion> findAll() {
		return Arrays.asList(template.getForObject(URL, CursoDTO[].class))
		.stream().map(c -> new Formacion(c.getNombre(), c.getDuracion(), c.getPrecio()))
		.toList();
	}

	/**
	 * Método que comprueba si existe un curso con ese nombre y si no parsea el
	 * objeto Fromacion a objeto Curso y lo inserta en CursosCRUD
	 * @param objeto Formacion
	 */
	@Override
	public void insert(Formacion formacion) {
		CursoDTO curso = template.getForObject(URL + "/nombre/" + formacion.getCurso(), CursoDTO.class);
		if (curso == null) {
			curso = new CursoDTO(formacion.getCurso(), formacion.getAsignaturas()*10, formacion.getPrecio());
			template.postForLocation(URL, curso);
		}
	}

}
