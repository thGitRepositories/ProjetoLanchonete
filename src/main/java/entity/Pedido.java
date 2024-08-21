package entity;

import java.util.Objects;

public class Pedido {
	private Long id;
	private Long cliente_id;
	private Long status_id;
	private String name;
	private Double price;
	private Integer quantiy;
	public Pedido(Long id, Long cliente_id, Long status_id, String name, Double price, Integer quantiy) {
		super();
		this.id = id;
		this.cliente_id = cliente_id;
		this.status_id = status_id;
		this.name = name;
		this.price = price;
		this.quantiy = quantiy;
	}
	public Pedido() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}
	public Long getStatus_id() {
		return status_id;
	}
	public void setStatus_id(Long status_id) {
		this.status_id = status_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantiy() {
		return quantiy;
	}
	public void setQuantiy(Integer quantiy) {
		this.quantiy = quantiy;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente_id, id, name, price, quantiy, status_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente_id, other.cliente_id) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(price, other.price)
				&& Objects.equals(quantiy, other.quantiy) && Objects.equals(status_id, other.status_id);
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente_id=" + cliente_id + ", status_id=" + status_id + ", name=" + name
				+ ", price=" + price + ", quantiy=" + quantiy + "]";
	}
	
	
	
	
}
