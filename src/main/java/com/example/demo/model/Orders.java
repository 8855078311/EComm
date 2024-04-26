package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	private Long order_id;
	private String order_name;
	private Long order_price;
	public Orders() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public Long getOrder_price() {
		return order_price;
	}
	public void setOrder_price(Long order_price) {
		this.order_price = order_price;
	}
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", order_name=" + order_name + ", order_price=" + order_price + "]";
	}
	
	
}
