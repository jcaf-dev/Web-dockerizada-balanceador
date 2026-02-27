package urjc.es.designs.entity;

public class Email {
	String listaDeCompra;
	String correoCliente;
	
	public Email() {
	}
	
	public Email(String listaDeCompra, String correoCliente) {
		super();
		this.listaDeCompra = listaDeCompra;
		this.correoCliente = correoCliente;
	}

	public String getListaDeCompra() {
		return listaDeCompra;
	}

	public void setListaDeCompra(String listaDeCompra) {
		this.listaDeCompra = listaDeCompra;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

}
