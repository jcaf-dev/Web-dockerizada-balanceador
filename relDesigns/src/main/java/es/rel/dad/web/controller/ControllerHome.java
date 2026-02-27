package es.rel.dad.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.rel.dad.web.entity.Author;
import es.rel.dad.web.entity.Client;
import es.rel.dad.web.entity.Item;
import es.rel.dad.web.repository.AuthorRepository;
import es.rel.dad.web.repository.ClientRepository;
import es.rel.dad.web.repository.ItemRepository;

@Controller
public class ControllerHome {

	
	@Autowired private ClientRepository client;
	@Autowired private ItemRepository items;
	@Autowired private AuthorRepository author;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	 public void init(){
		
		Item item1 = new Item("La escuela de Atenas", 14, 5);
		Item item2 = new Item("La Bella Jardinera", 6, 3);
		Item item3 = new Item("El grito", 7, 5);
		Item item4 = new Item("Ansiedad", 8, 2);
		Item item5 = new Item("La Gioconda", 8, 2);
		
		List<Item> Things = new ArrayList<Item>();
		Things.add(item1);
		Things.add(item2);
		
		List<Item> Things2 = new ArrayList<Item>();
		Things2.add(item3);
		Things2.add(item4);
		
		List<Item> Things3 = new ArrayList<Item>();
		Things3.add(item5);

		Client C1 = new Client("Rel","Flores Angulo",625983775,"jcarlosfa.rel@gmail.com","C/Las Flores",passwordEncoder.encode("1234"), "USER");
		Client C2 = new Client("Alberto","Del Pozo",123456789,"usuario@gmail.com","C/Calle Del Mar",passwordEncoder.encode("1111"), "USER");
		
		Author cx1 = new Author("Rafael",Things); 
		Author cx2 = new Author("Edvard Munch",Things2); 
		Author cx3 = new Author("Leonardo da Vinci",Things3);
		 
		
		items.save(item1);
		items.save(item2);
		items.save(item3);
		items.save(item4);
		items.save(item5);
		
		author.save(cx1); 
		author.save(cx2); 
		author.save(cx3);
		client.save(C1); 
		client.save(C2);

	 }
	 
	//Controller principal HOME
	

	
	@GetMapping("/home2/{name}")
	public String home2(Model model,  @PathVariable String name, HttpServletRequest request){
		model.addAttribute("user", request.isUserInRole("USER"));
		Optional<Client> c = client.findByName(name);
		if(c != null)
			model.addAttribute("client", c);
		
		return "home";
	}
	
	@GetMapping("/")
	public String index() {
	return "home";
	}
	@GetMapping("/login")
	public String login(Model model, HttpServletRequest request) {
		model.addAttribute("error", false);
		return "login";
	
	}
	@GetMapping("/loginerror")
	public String loginerror(Model model) {
		model.addAttribute("error", true);
	return "login";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	
	@GetMapping("/home2")
	public String home2(Model model, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		Optional<Client> c = client.findByName(request.getUserPrincipal().getName());

		model.addAttribute("client",c.get());
		return "home";
	}

	@GetMapping("/logout")
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		}
	
		return "home";
	}
}