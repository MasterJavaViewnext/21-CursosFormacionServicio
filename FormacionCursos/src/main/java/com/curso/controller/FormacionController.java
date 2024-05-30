package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("formaciones")
public class FormacionController {
	
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

	@GetMapping("view")
	public String vistaFormaciones(Model model) {
		model.addAttribute("formaciones", service.findAll());
		return "formacion";
	}
	
	@GetMapping("insert")
	public String insertFormacionesGet(Model model) {
		Formacion formacion = new Formacion();
		model.addAttribute("formacion", formacion);
		return "insert";
	}
	
	@PostMapping("insert")
	public String insertFormacionesPost(@ModelAttribute("formacion") Formacion formacion) {
		service.insert(formacion);
		return "formacion";
	}
	
}
