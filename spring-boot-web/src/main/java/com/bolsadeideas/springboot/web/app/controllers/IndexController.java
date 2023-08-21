package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexController.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexController.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexController.listar.titulo}")
	private String textoListar;
	
	@GetMapping({"/index", "/", "/home"})
	public String index(Model modelParam) {
		modelParam.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model modelParamUsuario) {
		
		Usuario usuarioVariable = new Usuario();
		usuarioVariable.setNombre("Marcelo");
		usuarioVariable.setApellido("Guzman");
		usuarioVariable.setEmail("hola@emailPrueba.com");
		
		modelParamUsuario.addAttribute("titulo", textoPerfil.concat(usuarioVariable.getNombre()));
		modelParamUsuario.addAttribute("usuario", usuarioVariable);
		modelParamUsuario.addAttribute("mensaje", "Estamos trabajando para usted");
		
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model modelParamListar) {
		
		
		modelParamListar.addAttribute("titulo", textoListar);		
		
		return "listar";
		
	}
	
	@ModelAttribute("usuariosTemp")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> listaUsuarios = Arrays.asList(new Usuario("koyukal","koyukil","koyukol"),
				new Usuario("koyukal","koyukil","koyukol"),
				new Usuario("koyukal","koyukil","koyukol"),
				new Usuario("koyukal","koyukil","koyukol"));
		return listaUsuarios;
		
	}

}
