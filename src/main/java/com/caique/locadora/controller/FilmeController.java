package com.caique.locadora.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.caique.locadora.model.Filme;
import com.caique.locadora.repository.FilmeRepository;


@Controller
@RequestMapping("/filme")
public class FilmeController {

	@Autowired
	private FilmeRepository filmeRepository;
	Filme filme;

	@GetMapping("/")
	public ModelAndView listar() {
		List<Filme> filme = filmeRepository.findAll();
		return new ModelAndView("filme/lista").addObject("filme", filme);
	}

	@GetMapping("/catalogo")
	public ModelAndView catalogo() {
		List<Filme> filme = filmeRepository.findAll();
		return new ModelAndView("filme/catalogo").addObject("filme", filme);
	}

	@RequestMapping("/addFilme/{id}")
	public ModelAndView addFilme(@PathVariable int id) {
		Filme filme = filmeRepository.getOne(id);
		filme.addFilme(filme);
		return new ModelAndView("filme/listaPedido").addObject("filme", filme);
	}

	@PostMapping(value = "/salvar")
	public ModelAndView newFilme(Filme filme) {
		filmeRepository.save(filme);
		return new ModelAndView("redirect:/filme/");
	}

	@GetMapping("/deleteFilme/{id}")
	public ModelAndView deletarFilme(@PathVariable int id) {
		filmeRepository.deleteById(id);
		return new ModelAndView("redirect:/filme/");
	}

	@RequestMapping("/atualizarFilme/{id}")
	public ModelAndView atualizarFilme(@PathVariable int id) {
		Filme filme = filmeRepository.getOne(id);
		return new ModelAndView("filme/formularioUpdate").addObject("filme", filme);
	}

	@GetMapping("/novo")
	public ModelAndView adicionarNovo() {
		return new ModelAndView("filme/formulario").addObject("filme", new Filme());
	}

}
