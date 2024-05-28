package com.curso.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.cursos.model.Curso;
import com.curso.cursos.service.CursoService;

@RestController
@RequestMapping(path = "cursos")
public class CursoController {
	
	@Autowired
	CursoService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> findAll(){
		return service.findAll();
	}

	@GetMapping(value = "{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso findById(@PathVariable Integer codigo) {
		return service.findById(codigo).orElse(null);
	}
	
	@GetMapping(value = "/nombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso findByNnombre(@PathVariable String nombre) {
		return service.findByNombre(nombre).orElse(null);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> insert(@RequestBody Curso curso) {
		return service.insert(curso);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Curso curso) {
		service.update(curso);
	}
	
	@DeleteMapping(value = "{codigo}")
	public void delete(@PathVariable Integer codigo) {
		service.delete(codigo);
	}
	
	@PutMapping
	public void updateDuracion(@RequestParam("codigo") Integer codigo, @RequestParam("duracion") Integer duracion) {
		service.updateDuracion(codigo, duracion);
	}
	
	@GetMapping(value = "precio", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> findByPrecioBetween(@RequestParam("min") Integer min, @RequestParam("max") Integer max){
		return service.findByPrecioBetween(min, max);
	}
	
}
