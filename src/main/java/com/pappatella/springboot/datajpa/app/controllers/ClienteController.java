package com.pappatella.springboot.datajpa.app.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pappatella.springboot.datajpa.app.models.dao.IClienteDao;

@Controller
public class ClienteController {

	@Autowired
	private IClienteDao clienteDao;

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("clientes", clienteDao.findAll());
		return "clientes";
	}
}
