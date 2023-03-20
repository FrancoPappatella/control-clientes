package com.pappatella.springboot.datajpa.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pappatella.springboot.datajpa.app.models.entity.Cliente;
import com.pappatella.springboot.datajpa.app.models.entity.Factura;
import com.pappatella.springboot.datajpa.app.models.service.IClienteService;

@Controller
@SessionAttributes("factura")
@RequestMapping("/factura")
public class FacturaController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping("/form/{id}")
	public String crear(@PathVariable(name = "id") Long id, Model model, RedirectAttributes flash) {
		Cliente cliente = clienteService.findOne(id);

		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}
		
		Factura factura = new Factura();
		factura.setCliente(cliente);
		model.addAttribute("factura",factura);
		model.addAttribute("titulo", "Crear Factura");
		return "factura/form";
	}
}
