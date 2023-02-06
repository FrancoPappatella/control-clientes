package com.pappatella.springboot.datajpa.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pappatella.springboot.datajpa.app.models.dao.IClienteDao;
import com.pappatella.springboot.datajpa.app.models.entity.Cliente;
import com.pappatella.springboot.datajpa.app.models.service.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("clientes", clienteService.findAll());
		return "clientes";
	}

	@GetMapping("/form")
	public String crear(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("titulo", "Crear cliente");
		model.addAttribute("cliente", cliente);
		return "form";
	}

	@PostMapping("/form")
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Crear cliente");
			return "form";
		}

		clienteService.save(cliente);
		status.setComplete();
		return "redirect:listar";
	}

	@GetMapping("/form/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Cliente cliente = null;
		if (id > 0) {
			cliente = clienteService.findOne(id);
		} else {
			return "redirect:/listar";
		}
		model.addAttribute("titulo", "Editar cliente");
		model.addAttribute("cliente", cliente);
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		if (id > 0) {
			clienteService.delete(id);
		}

		return "redirect:/listar";
	}
}
