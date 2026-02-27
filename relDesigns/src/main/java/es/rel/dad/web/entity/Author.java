package es.rel.dad.web.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Author implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nameAuthor;
	
	@OneToMany
	private List <Item> items;
	
	public Author(){}
	public Author(String nameCategory, List<Item> items) {
		super();
		this.nameAuthor = nameCategory;
		this.items = items;
	}

	public String getName() {
		return nameAuthor;
	}

	public void setName(String nameCategory) {
		this.nameAuthor = nameCategory;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nameAuthor+ "]";
	}

}
