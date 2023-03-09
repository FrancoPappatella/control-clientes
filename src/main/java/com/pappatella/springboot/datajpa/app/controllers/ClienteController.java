package com.pappatella.springboot.datajpa.app.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pappatella.springboot.datajpa.app.models.dao.IClienteDao;
import com.pappatella.springboot.datajpa.app.models.entity.Cliente;
import com.pappatella.springboot.datajpa.app.models.service.IClienteService;
import com.pappatella.springboot.datajpa.app.paginator.PageRender;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	private final Logger log = LoggerFactory.getLogger(getClass());
	private final String UPLOAD_FOLDER = "uploads";

	/*
	 * @GetMapping("/uploads/{filename:.+}") public ResponseEntity<Resource>
	 * verFoto(@PathVariable String filename) { Path pathFoto =
	 * Paths.get("uploads").resolve(filename).toAbsolutePath();
	 * 
	 * log.info(" *** pathFoto = " + pathFoto); Resource recurso = null; try {
	 * recurso = new UrlResource(pathFoto.toUri()); if(!recurso.exists() &&
	 * !recurso.isReadable()) { throw new
	 * RuntimeException("No se puede cargar la imagen : " + pathFoto.toString()); }
	 * } catch (MalformedURLException e) { e.printStackTrace(); } return
	 * ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
	 * "attachment; filename=\"" + recurso.getFilename() + "\"").body(recurso);
	 * 
	 * }
	 */

	@GetMapping("/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		Cliente cliente = clienteService.findOne(id);
		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}

		model.addAttribute("cliente", cliente);
		return "ver";

	}

	@GetMapping("/listar")
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 4);
		Page<Cliente> clientes = clienteService.findAll(pageRequest);

		PageRender<Cliente> pageRender = new PageRender<>("/listar", clientes);
		model.addAttribute("clientes", clientes);

		model.addAttribute("page", pageRender);
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
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Crear cliente");
			return "form";
		}
		if (!foto.isEmpty()) {
			if (cliente.getId() != null && cliente.getId() > 0 && cliente.getFoto() != null
					&& cliente.getFoto().length() > 0) {
				Path rootPath = Paths.get(UPLOAD_FOLDER).resolve(cliente.getFoto()).toAbsolutePath();
				File archivo = rootPath.toFile();
				if (archivo.exists() && archivo.canRead()) {
					if (archivo.delete()) {
						flash.addFlashAttribute("success", "¡Foto eliminada con exito: " + cliente.getFoto() + "!");
					}
				}
			}
			String uniqueFilename = UUID.randomUUID().toString() + "_" + foto.getOriginalFilename();
			Path rootPath = Paths.get(UPLOAD_FOLDER).resolve(uniqueFilename);
			Path rootAbsolutPath = rootPath.toAbsolutePath();
			try {
				Files.copy(foto.getInputStream(), rootAbsolutPath);
				flash.addFlashAttribute("info", "Subiste correctamente " + foto.getOriginalFilename());
				cliente.setFoto(uniqueFilename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String mensajeFlash = cliente.getId() == null ? "¡El cliente fue creado con éxito!"
				: "¡El cliente fue editado con éxito!";
		clienteService.save(cliente);
		status.setComplete();

		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}

	@GetMapping("/form/{id}")
	public String editar(@PathVariable Long id, Model model, RedirectAttributes flash) {
		Cliente cliente = null;
		if (id > 0) {
			cliente = clienteService.findOne(id);
			if (cliente == null) {
				flash.addFlashAttribute("error", "¡El id del cliente no existe en la Base de datos!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "¡El id del cliente no puede ser 0!");
			return "redirect:/listar";

		}
		model.addAttribute("titulo", "Editar cliente");
		model.addAttribute("cliente", cliente);
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
		if (id > 0) {
			Cliente cliente = clienteService.findOne(id);
			clienteService.delete(id);
			flash.addFlashAttribute("success", "¡El cliente fue eliminado con éxito!");

			Path rootPath = Paths.get(UPLOAD_FOLDER).resolve(cliente.getFoto()).toAbsolutePath();
			File archivo = rootPath.toFile();
			if (archivo.exists() && archivo.canRead()) {
				if (archivo.delete()) {
					flash.addFlashAttribute("success", "¡Foto eliminada con exito: " + cliente.getFoto() + "!");
				}
			}
		}

		return "redirect:/listar";
	}
}
