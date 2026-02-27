package es.rel.dad.web.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String surname;
	private int telephone;
	private String mail;
	private String address;
	
	
	@JsonIgnore
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	
	
	private ArrayList <String> carrito;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List <Item> items;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List <Orders> orders;
	
	public Client() {}
	
	public Client(String name, String password, List<String> roles) {
		super();
		this.name = name;
		this.password = password;
		this.roles = roles;
		
	}
	public Client(String name, String surname, int telephone, String mail, String address, String password
			,  String... roles) {
		super();
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
		this.mail = mail;
		this.address = address;
		this.password = password;
		this.orders = new ArrayList<Orders>();
		this.carrito = new ArrayList<String>();
		this.items = new ArrayList<Item>();
		this.roles = List.of(roles);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public ArrayList<String> getCarrito() {
		return carrito;
	}

	public void setCarrito(ArrayList<String> carrito) {
		this.carrito = carrito;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	

	
	@Override
	public int hashCode() {
		int hash = 1;
        hash = hash * 17 + (int)this.id;
        hash = hash * 31 + name.hashCode();
        return hash;
		
	}
		
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + name + ", surmane=" + surname + "]";
	}
	
}
