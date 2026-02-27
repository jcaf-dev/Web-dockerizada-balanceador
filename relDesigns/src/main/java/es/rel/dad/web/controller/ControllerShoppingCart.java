package es.rel.dad.web.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import es.rel.dad.web.entity.Author;
import es.rel.dad.web.entity.Client;
import es.rel.dad.web.entity.EmailBody;
import es.rel.dad.web.entity.Item;
import es.rel.dad.web.entity.Orders;
import es.rel.dad.web.repository.AuthorRepository;
import es.rel.dad.web.repository.ClientRepository;
import es.rel.dad.web.repository.ItemRepository;
import es.rel.dad.web.repository.OrdersRepository;


@Controller
public class ControllerShoppingCart {

	
	@Autowired private ClientRepository client;
	@Autowired private OrdersRepository orders;
	@Autowired private ItemRepository items;
	@Autowired private AuthorRepository author;

	@GetMapping("/cart/{name}/{nameItem}/{nameAuthor}")
	public String carrito(Model model, @PathVariable String name,  @PathVariable String nameItem, @PathVariable String nameAuthor) {
				
		Optional<Client> c = client.findByName(name);
		Author cate = author.findByNameAuthor(nameAuthor);
		
		List <Item> aux = new ArrayList<Item>(cate.getItems());
		Item itemAux = items.findByNameItem(nameItem);
		
		if(c.get().getCarrito().contains(nameItem) == false) {
			c.get().getItems().add(itemAux);
		}
		
		if(itemAux.getStock() > 0) {
			itemAux.setStock( itemAux.getStock()-1);
			c.get().getCarrito().add(nameItem);
			client.save(c.get());
			items.save(itemAux);
		}

		model.addAttribute("items", aux);		
		model.addAttribute("client",c.get());
		model.addAttribute("author",cate);
		return "authorItems";
	}
	
	@GetMapping("/shoppingCart")
	public String shoppingCart(Model model) {
	
		return "shoppingcart";
	}
	
	@GetMapping("/shoppingCart/{name}")
	public String shoppingCart(Model model, @PathVariable String name, HttpServletRequest request) {
		
		Optional<Client> c = client.findByName(name);

		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("client",c.get());
		return "shoppingcart";
	}

	@GetMapping("/pay/{name}")
	public String pay(Model model, @PathVariable String name, HttpServletRequest request) {
		
		
		Optional<Client> c = client.findByName(name);
		if(c.get().getCarrito().size() > 0) {
			
			for(Item xx : c.get().getItems()) {
				System.out.println("Name : "+xx.getName());
			}
			
			List<Item> aux = new ArrayList<Item>(c.get().getItems());
			Orders orden1 = new Orders(aux);	
			orders.save(orden1);
			
			c.get().setCarrito(new ArrayList<String>());
			c.get().setItems(new ArrayList<Item>());
			c.get().getOrders().add(orden1);
			client.save(c.get());
	
			
			String pedido = new String("Este correo se ha generado de forma automatica, no conteste: \n\n");
			List <Orders> ordenes = c.get().getOrders();
			for(Orders ordenesAux : ordenes) {
				for(Item items : ordenesAux.getItems()){
					pedido = pedido + items.getName()+ "\n";
				}
			}
			pedido = pedido + "\nUn saludo de parte del equipo de RelDesigns";
			
			RestTemplate restTemplate = new RestTemplate();
			String url="http://haproxyR:8090/email/send";
			
			HttpEntity<EmailBody> mailBody = new HttpEntity<>(new EmailBody(c.get().getMail(),pedido,"Factura Generada"));	
			
			
			//ResponseEntity<String> enviar = restTemplate.postForEntity("http://haproxyR:8011/email/send", mailBody, String.class);
		
			try{
				
		        restTemplate.postForEntity(url, mailBody, String.class);
		    
			}catch(HttpStatusCodeException e){}
		}

		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("client",c.get());
		return "shoppingcart";
	}
	
	@GetMapping("/delete/{name}/{food}")
	public String delete(Model model, @PathVariable String name, @PathVariable String food,  HttpServletRequest request) {
		Optional<Client> c = client.findByName(name);
		
		Iterator<Item> iter = c.get().getItems().iterator();
				
		
		while(iter.hasNext()){
			Item auxIt = iter.next();
			if(auxIt.getName().equals(food)) {
				iter.remove();
				c.get().getCarrito().remove(food);
			}
		}

		// Cambios
		client.save(c.get());
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("client",c.get());
		return "shoppingcart";
	}
	
	
}
