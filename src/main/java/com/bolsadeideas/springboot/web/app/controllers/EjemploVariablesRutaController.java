package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	
	@GetMapping("/string/{textoUrl}")
	public String variableMethod(@PathVariable String textoUrl, Model modelParam) {
		modelParam.addAttribute("titulo","Enviando el titulo desde la ruta del controlador(@PathVariable)");
		modelParam.addAttribute("resultado","el texto enviado en la ruta es: " + textoUrl);
		return "variables/ver";
	}

}
