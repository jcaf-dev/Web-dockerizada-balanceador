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
public class ControllerSingIn {

	@Autowired private ClientRepository client;

	@PostMapping("/newUser")
	public String newUser(Model model, @RequestParam String name, @RequestParam String surname, @RequestParam String telephone, @RequestParam String mail, @RequestParam String address, @RequestParam String password) 
	{
		
		Client c = new Client(name, surname,Integer.parseInt(telephone), mail, address, password);
		client.save(c);
		model.addAttribute("id",c.getId());
		model.addAttribute("client", c);
		return "home";
	}
	
/*	
	  @PostMapping("/loginBBDD") 
	  public String login(Model model, @RequestParam String name, @RequestParam String password,  HttpServletRequest request) { 
		  Client c = client.findByNameAndPassword(name,password); 
		  if(c !=null) {
			  model.addAttribute("fallo", false);
			  model.addAttribute("id",c.getId()); model.addAttribute("client", c); } 
		  return "home"; 
	  }
	 
*/
	@GetMapping("/datosClient/{name}")
	public String datosClient(Model model, @PathVariable String name,  HttpServletRequest request) {
		Optional<Client> c = client.findByName(name);
		if(c.get() != null)
			model.addAttribute("client", c.get());

		model.addAttribute("client",c.get());
		model.addAttribute("user", request.isUserInRole("USER"));

		return "datosClient";
	}
	@GetMapping("/createaccount")
	public String createaccount(Model model) {
		return "createaccount";
	}
	
}
