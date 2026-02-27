package es.rel.dad.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ControllerArtGallery {

	@Autowired private ClientRepository client;
	@Autowired private ItemRepository items;
	@Autowired private AuthorRepository author;
	
	@GetMapping("/artGallery")
	public String artGallery(Model model){
		List <Item> aux = new ArrayList<Item>(items.findAll());
		List<Author> cate = new ArrayList<Author>(author.findAll());
		model.addAttribute("author",cate);
		model.addAttribute("items", aux);
		
		return "artGallery";
	}
	
	@GetMapping("/artGallery/{name}")
	public String artGallery(Model model,  @PathVariable String name,  HttpServletRequest request){
		Optional<Client> c = client.findByName(name);
		model.addAttribute("user", request.isUserInRole("USER"));
		List<Author> cate = new ArrayList<Author>(author.findAll());
		
		model.addAttribute("author",cate);
		model.addAttribute("client",c.get());
		return "artGallery";
	}
	
	@GetMapping("/author/{nameAuthor}")
	public String aniadir(Model model, @PathVariable String nameAuthor) {
		
		Author cate = author.findByNameAuthor(nameAuthor);
		List <Item> aux = new ArrayList<Item>(cate.getItems());		
		
		model.addAttribute("items", aux);		
		return "authorItems";
	}
	
	@GetMapping("/author/{name}/{nameAuthor}")
	public String aniadir(Model model,@PathVariable String name, @PathVariable String nameAuthor,  HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		Optional<Client> c = client.findByName(name);
		Author cate = author.findByNameAuthor(nameAuthor);
		List <Item> aux = new ArrayList<Item>(cate.getItems());
		model.addAttribute("author", cate);	
		model.addAttribute("items", aux);		
		model.addAttribute("client",c.get());
		return "authorItems";
		
	}

}
