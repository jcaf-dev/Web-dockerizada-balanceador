package es.rel.dad.web.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nameItem;
	private double price;
	private int stock;
	public String getName() {
		return nameItem;
	}
	public Item(){}
	public Item(String nameItem, double price, int stock) {
		super();
		this.nameItem = nameItem;
		this.price = price;
		this.stock = stock;
	}
	


	public String getNameItem() {
		return nameItem;
	}
	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		int hash = 1;
        hash = hash * 17 + (int)this.id;
        hash = hash * 31 + nameItem.hashCode();
        return hash;
		
	}
		
	@Override
	public String toString() {
		return "Items [id=" + id + ", nombre=" + nameItem + ", price=" + price + "]";
	}
	
	
	
	
}
