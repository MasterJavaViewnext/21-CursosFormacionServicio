package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.model.Formacion;
import com.curso.service.FormacionService;


@Controller
@RequestMapping("formaciones")
public class FormacionController {
	
	@Autowired
	FormacionService service;

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
