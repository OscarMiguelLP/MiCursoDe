package com.micursode.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.micursode.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	String textoIndex;
	
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	@GetMapping({ "/index", "/", "/home" })
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("titulo", textoIndex);
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {

		Usuario usuario = new Usuario();
		usuario.setNombre("Oscar");
		usuario.setApellido("Lopez");

		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

		model.addAttribute("usuario", usuario);
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Miguel", "Perez", "mperez@mperez.org"));
		usuarios.add(new Usuario("Oscar", "Lopez", "olopez@olopez.org"));
		usuarios.add(new Usuario("Juan", "Palomo", "meguisoloquemecomo@yosolo.ñam"));
		usuarios.add(new Usuario("Invitado", "Guess", null));
		

		
		
		model.addAttribute("titulo", textoListar);
		//model.addAttribute("usuarios", usuarios);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Miguel", "Perez", "mperez@mperez.org"),
				new Usuario("Oscar", "Lopez", "olopez@olopez.org"),
				new Usuario("Juan", "Palomo", "meguisoloquemecomo@yosolo.ñam"), new Usuario("Invitado", "Guess", "lal"));
		return usuarios;
	}

}
