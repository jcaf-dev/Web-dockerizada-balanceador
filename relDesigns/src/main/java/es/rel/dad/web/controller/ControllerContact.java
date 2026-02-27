package es.rel.dad.web.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.rel.dad.web.entity.Client;
import es.rel.dad.web.repository.ClientRepository;


@Controller
public class ControllerContact {
	@Autowired private ClientRepository client;
	
	@GetMapping("/contact")
	public String contact(Model model) {
		return "contact";
	}
	
	@GetMapping("/contact/{name}")
	public String contact(Model model, @PathVariable String name,  HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		Optional <Client> c = client.findByName(name);
		model.addAttribute("client",c.get());
		return "contact";
	}
	
	@PostMapping("/contact/message")
	public String contactMessage(Model model,  @RequestParam String name,  @RequestParam String email,  @RequestParam String message) {
		System.out.println("Hola, este es el mensaje: "+ message);
		return "contact";
	}
}
