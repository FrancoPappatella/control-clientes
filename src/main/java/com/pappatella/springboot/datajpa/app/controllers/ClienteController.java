package com.pappatella.springboot.datajpa.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pappatella.springboot.datajpa.app.models.dao.IClienteDao;
import com.pappatella.springboot.datajpa.app.models.entity.Cliente;

@Controller
public class ClienteController {

	@Autowired
	private IClienteDao clienteDao;

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("clientes", clienteDao.findAll());
		return "clientes";
	}
	
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		return "form";
	}
	
	@PostMapping("/form")
	public String guardar(Cliente cliente) {
		clienteDao.save(cliente);
		return "redirect:listar";
	}
}
