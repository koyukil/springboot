package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name="textoParam", required = false, defaultValue = "Escribe en el link") String textoParam, Model modelParam) {
		
		modelParam.addAttribute("resultado", "El texto enviado es : " + textoParam);
		
		return "params/ver";
		
	}
	
	@GetMapping("/mix-params")
	public String MixParam(@RequestParam String saludoMixParam,@RequestParam Integer numeroMixParam , Model modelMixParam) {
		
		modelMixParam.addAttribute("resultado", "El saludo enviado es : " + saludoMixParam + " y el numero es "+ numeroMixParam);
		
		return "params/ver";
		
	}
	
	@GetMapping("/mix-params-request")
	public String MixParam(HttpServletRequest resquestMixParam , Model modelMixParam) {
		String saludoMixValue = resquestMixParam.getParameter("saludoMixParam");
		Integer numeroMixValue = null;
		try {
		numeroMixValue = Integer.parseInt(resquestMixParam.getParameter("numeroMixParam"));
		} catch (NumberFormatException e) {
			numeroMixValue = 0;
		}
		modelMixParam.addAttribute("resultado", "El saludo enviado es : " + saludoMixValue + " y el numero es "+ numeroMixValue);
		
		return "params/ver";
		
	}

}
