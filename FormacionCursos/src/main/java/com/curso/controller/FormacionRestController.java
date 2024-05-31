package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionService;

@RestController
@RequestMapping("formaciones")
public class FormacionRestController {

	@Autowired
	FormacionService service;
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	List<Formacion> findAll() {
		return service.findAll();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	void insert(@RequestBody Formacion formacion) {
		service.insert(formacion);
	}

}
